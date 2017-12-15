package com.tany.jpos.pacakger;


import com.tany.jpos.ISOBitMap;
import com.tany.jpos.ISOBitMapPackager;
import com.tany.jpos.ISOField;

public class IFA_BitMap extends ISOBitMapPackager{

    @Override
    public ISOBitMap unPackbody(byte[] b) {

        return null;
    }

    @Override
    public byte[] pack(ISOBitMap isoBitMap) {
        return new byte[0];
    }
}
