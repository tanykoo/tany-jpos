package com.tany.jpos;

public class ISOBinaryField extends ISOField{

    public ISOBinaryField(){
        type="binary";
    }
    @Override
    public byte[] getValue() {
        return (byte[]) value;
    }
}
