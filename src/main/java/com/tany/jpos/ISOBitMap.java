package com.tany.jpos;

import java.util.BitSet;

/**
 * @Author ThinkPad
 * @Since 1.0
 */
public class ISOBitMap extends ISOField{

    {
        type="bitmap";
    }

    @Override
    public BitSet getValue() {
        return (BitSet) value;
    }
}
