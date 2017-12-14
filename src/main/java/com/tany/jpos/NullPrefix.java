package com.tany.jpos;

/**
 * @Author ThinkPad
 * @Since
 */
public class NullPrefix implements Prefix {
    @Override
    public int unpack(byte[] b, int offset) {
        return 0;
    }

    @Override
    public byte[] pack(int length) {
        return null;
    }

    @Override
    public int getPrefixLen() {
        return NOPREFIX;
    }
}
