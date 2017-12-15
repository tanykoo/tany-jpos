package com.tany.jpos.interfaces;


import com.tany.jpos.ISOException;
import com.tany.jpos.ISOField;

public interface Padder {
    public ISOField pad(ISOField isoField)throws ISOException;
    public ISOField unPad(ISOField isoField)throws ISOException;
}
