package com.tany.jpos.pacakger;


import com.tany.jpos.ISOBitMapPackager;
import com.tany.jpos.util.JPosUtils;

public class IFA_BitMap extends ISOBitMapPackager{

    @Override
    protected byte[] toBinaryByte(byte[] b, int offset) {
        int bit = 0;
        if(((b[offset] & 0xff) - 0x30) >= 0x08){
            bit = 128;
        }else
            bit = 64;
        byte[] bitMapbytes = new byte[bit >> 2];
        System.arraycopy(b, offset, bitMapbytes, 0, bitMapbytes.length);
        return bitMapbytes;
    }

    @Override
    protected int getLength(byte[] b) {
        return b.length << 2;
    }

    @Override
    public byte[] toLocalByte(byte [] bitMap) {
        byte tmp [] = new byte[bitMap.length << 1 ];
        for(int i = 0; i<bitMap.length; i++){
            tmp[i * 2] = (byte)JPosUtils.UPPER_HEX_STR.charAt((((bitMap[i] & 0xff) >> 4) & 0x0f));
            tmp[i * 2 + 1] = (byte)JPosUtils.UPPER_HEX_STR.charAt(bitMap[i] & 0x0f);
        }
        return tmp;
    }
}
