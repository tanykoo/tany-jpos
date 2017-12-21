package com.tany.jpos.iso;

import com.tany.jpos.util.JPosUtils;
import com.tany.jpos.util.StringUtils;

/**
 * @Author ThinkPad
 * @Since 1.0
 */
public class ISOABitMapPackager extends ISOBitMapPackager{

    @Override
    protected byte[] toBitBytes(byte[] bitmap) {
        return StringUtils.hex2byte(new String(bitmap));
    }

    @Override
    public int getLength(byte[] b) {
        int bit = 0;
        if(((b[0] & 0xff) - 0x30) >= 0x08){
            return 128 >> 2;
        }else
            return 64 >> 2;
    }

    @Override
    public byte[] toLocalByte(byte [] bitMap) {
        byte tmp [] = new byte[bitMap.length << 1 ];
        for(int i = 0; i<bitMap.length; i++){
            tmp[i * 2] = (byte) JPosUtils.UPPER_HEX_STR.charAt((((bitMap[i] & 0xff) >> 4) & 0x0f));
            tmp[i * 2 + 1] = (byte)JPosUtils.UPPER_HEX_STR.charAt(bitMap[i] & 0x0f);
        }
        return tmp;
    }
}
