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
    public abstract ISOBitMap unPack(byte[] b, int offset);
}
