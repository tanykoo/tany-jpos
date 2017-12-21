package com.tany.jpos.iso;

import com.tany.jpos.util.JPosUtils;
import com.tany.jpos.util.StringUtils;

/**
 * @Author ThinkPad
 * @Since 1.0
 */
public class ISOBBitMapPackager extends ISOBitMapPackager{

    @Override
    public int getLength(byte[] bitMap) {
        return (bitMap[0] & 0x80) == 0 ? 64 >> 3 : 128 >> 3;
    }

    @Override
    protected byte[] toLocalByte(byte[] bitmap) {
        return bitmap;
    }

    @Override
    protected byte[] toBitBytes(byte[] bitmap) {
        return bitmap;
    }
}
