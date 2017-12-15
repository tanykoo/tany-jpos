package com.tany.jpos;

import java.util.BitSet;

/**
 * @Author ThinkPad
 * @Since 1.0
 */
public abstract class ISOBitMapPackager extends ISOFieldPackager{

    {
        this.padder = new NullPadder();
        this.prefix = new NullPrefix();
    }

    @Override
    public ISOBitMap unPack(byte b[] , int offset){


        return unPackbody(b);
    }



    @Override
    protected ISOBitMap unPackbody(byte[] b){

        ISOBitMap isoBitMap = new ISOBitMap();
        isoBitMap.setValue(unPack(b));
        isoBitMap.setLength(getLength(b));

        return isoBitMap;
    }

    protected abstract int getLength(byte[] b);

    @Override
    public byte[] packbody(ISOField isoField) {
        return this.pack((ISOBitMap) isoField);
    }

    protected abstract byte[] pack(ISOBitMap isoBitMap);

    protected BitSet unPack(byte[] b){
        BitSet bitSet = new BitSet(((b[0] & 0x80) == 0)? 64 : 128);
        for(int i=0; i < bitSet.length(); i++){
            if(((b[i>>3] >>> i%8) & 0x01) == 1 ){
                bitSet.set(i);
            }
        }
        return  bitSet;
    }

}
