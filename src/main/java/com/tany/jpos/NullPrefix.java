package com.tany.jpos;

import com.tany.jpos.interfaces.Prefix;

/**
 * @Author ThinkPad
 * @Since
 */
public class NullPrefix implements Prefix {
    @Override
    public int unpack(byte[] b, int offset) {
        return NOPREFIX;
    }

    @Override
    public byte[] pack(int length) {
        return new byte[0];
    }

    @Override
    public int getPrefixByteLen() {
        return 0;
    }

    @Override
    public void setPrefixLen(int prefixLen){

    }
}
