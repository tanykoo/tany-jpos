package com.tany.jpos.iso;

import com.tany.jpos.iso.ISOField;

public class ISOBCDFiled  extends ISOField {

    public ISOBCDFiled(){
        type="bcd";
    }

    @Override
    public String getValue() {
        return (String) value;
    }

    @Override
    public String toString() {
        return getValue();
    }

}
