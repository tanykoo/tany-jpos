package com.tany.jpos.interfaces;


import com.tany.jpos.ISOField;

public interface Padder {
    public ISOField pad(ISOField isoField);
    public ISOField unPad(ISOField isoField);
}
