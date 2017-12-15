package com.tany.jpos;

import com.tany.jpos.interfaces.Prefix;

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
    public int getPrefixByteLen() {
        return NOPREFIX;
    }

    @Override
    public void setPrefixLen(int prefixLen){

    }
}
