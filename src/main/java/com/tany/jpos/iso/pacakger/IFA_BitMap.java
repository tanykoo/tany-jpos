package com.tany.jpos.iso.pacakger;

import com.tany.jpos.iso.BaseISOFieldPackager;
import com.tany.jpos.iso.ISOABitMapPackager;

public class IFA_BitMap extends BaseISOFieldPackager{
    public IFA_BitMap() {
        super(new ISOABitMapPackager(),16);
    }

    @Override
    public void setMaxlen(int maxlen) {
        super.setMaxlen(16);
    }
}
