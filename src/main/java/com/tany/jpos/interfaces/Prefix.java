package com.tany.jpos.interfaces;

public interface Prefix {

    int NOPREFIX = -1;

    int unpack(byte b[],int offset);

    byte[] pack(int length);

    int getPrefixByteLen();

    void setPrefixLen(int prefixLen);

}
