package com.tany.jpos.interfaces;


import com.tany.jpos.ISOException;
import com.tany.jpos.ISOField;

public interface Padder {
    ISOField pad(ISOField isoField)throws ISOException;
    ISOField unPad(ISOField isoField)throws ISOException;
}
