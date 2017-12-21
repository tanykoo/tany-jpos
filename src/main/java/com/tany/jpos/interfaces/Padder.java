package com.tany.jpos.interfaces;


import com.tany.jpos.JPOSException;
import com.tany.jpos.NullPadder;
import com.tany.jpos.iso.ISOField;

public interface Padder {
    Padder NULL_PADDER = new NullPadder();

    ISOField pad(ISOField isoField, int len)throws JPOSException;
    ISOField unPad(ISOField isoField, int len)throws JPOSException;
}
