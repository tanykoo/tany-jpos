package com.tany.jpos;

import com.tany.jpos.interfaces.Padder;
import com.tany.jpos.iso.ISOField;

/**
 * @Author ThinkPad
 * @Since 1.0
 */
public class NullPadder implements Padder {
    @Override
    public ISOField pad(ISOField isoField, int len) {
        return isoField;
    }

    @Override
    public ISOField unPad(ISOField isoField, int len) {
        return isoField;
    }
}
