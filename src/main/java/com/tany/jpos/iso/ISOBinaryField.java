package com.tany.jpos.iso;

import com.tany.jpos.util.StringUtils;

public class ISOBinaryField extends ISOField {

    public ISOBinaryField(){
        type="binary";
    }
    @Override
    public byte[] getValue() {
        return (byte[]) value;
    }

    @Override
    public String toString() {
        return StringUtils.byte2hex(getValue());
    }
}
