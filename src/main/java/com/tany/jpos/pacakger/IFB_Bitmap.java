package com.tany.jpos.pacakger;

import com.tany.jpos.ISOBitMap;
import com.tany.jpos.ISOBitMapPackager;
import com.tany.jpos.ISOField;

public class IFB_Bitmap extends ISOBitMapPackager{
    @Override
    protected byte[] toBinaryByte(byte[] b, int offset) {
        int bitset = (b[offset] & 0x80) == 0 ? 64 : 128;
        byte [] bitMap = new byte[bitset >> 3];
        System.arraycopy(b, offset, bitMap, 0, bitMap.length);
        return bitMap;
    }

    @Override
    protected int getLength(byte[] bitMap) {
        return bitMap.length;
    }

    @Override
    protected byte[] toLocalByte(byte[] bitmap) {
        return bitmap;
    }
}
