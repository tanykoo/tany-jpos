package com.tany.jpos;

public class ISOBCDFiled  extends ISOField{

    public ISOBCDFiled(){
        type="bcd";
    }

    @Override
    public String getValue() {
        return (String) value;
    }
}
