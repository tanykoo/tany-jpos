package com.tany.jpos.interfaces;

import com.tany.jpos.NullPrefix;

public interface Prefix {

    int NOPREFIX = -1;
    Prefix NULL_PREFIX = new NullPrefix();

    int unpack(byte b[],int offset);

    byte[] pack(int length);

    int getPrefixByteLen();

    void setPrefixLen(int prefixLen);

}
