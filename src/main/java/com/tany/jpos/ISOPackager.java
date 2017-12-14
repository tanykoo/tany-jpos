package com.tany.jpos;

import com.tany.jpos.interfaces.Msg;
import com.tany.jpos.interfaces.Packager;

import javax.print.attribute.standard.MediaSize;
import java.util.BitSet;
import java.util.Hashtable;

public class ISOPackager implements Packager {

    private ISOFieldPackager[] headPackagers;

    private Hashtable<Integer,ISOFieldPackager> bodyPackagers;

    private boolean hasMsgType = false;

    @Override
    public ISOMsg unpack(byte[] b) throws ISOException {
        ISOMsg isoMsg = new ISOMsg();
        ISOField [] head = new ISOField[headPackagers.length];
        int offset = 0;
        for(int i =0 ; i < headPackagers.length ;i++){
            head[i] = headPackagers[i].unPack(b,offset);
            offset += head[i].getLength();
        }
        isoMsg.setHead(head);
        int bitmapSet = 0;
        ISOBitMap bitMap = null;
        for(Integer i : bodyPackagers.keySet()){
            if(bodyPackagers.get(i) instanceof ISOBitMapPackager){
                bitMap = ((ISOBitMapPackager)bodyPackagers.get(i)).unPack(b,offset);
                bitmapSet = i;
                offset += bitMap.getLength();
                isoMsg.addBody(bitMap);
                break;
            }else{
                ISOField isoField = bodyPackagers.get(i).unPack(b,offset);
                offset += isoField.getLength();
                isoMsg.addBody(isoField);
            }
        }
        if(bitMap == null ){
            throw new ISOException("报文配置错误,没有位图","10000");
        }
        for(int i = bitmapSet; i < 128 ; i++){
            BitSet bitSet = bitMap.getValue();
            if(bitSet.get(i)){
                ISOField isoField = bodyPackagers.get(i).unPack(b,offset);
                offset += isoField.getLength();
                isoMsg.addBody(isoField);
            }
        }
        return isoMsg;
    }

    @Override
    public byte[] pack(Msg msg) {
        return new byte[0];
    }
}
