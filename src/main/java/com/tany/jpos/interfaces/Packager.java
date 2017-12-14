package com.tany.jpos.interfaces;

import com.tany.jpos.ISOException;

public interface Packager {
    public Msg unpack(byte [] b) throws ISOException;
    public byte[] pack(Msg msg) throws ISOException;
}
