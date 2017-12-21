package com.tany.jpos.iso.pacakger;

import com.tany.jpos.iso.BaseISOFieldPackager;
import com.tany.jpos.iso.ISOBBitMapPackager;

public class IFB_BitMap extends BaseISOFieldPackager{

    public IFB_BitMap(){
        super(new ISOBBitMapPackager(),32);
    }
}
