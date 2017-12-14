package com.tany.jpos.interfaces;

public interface Prefix {

    int NOPREFIX = -1;

    public int unpack(byte b[],int offset);

    public byte[] pack(int length);

    public int getPrefixLen();

}
