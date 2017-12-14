package com.tany.jpos;

/**
 * @Author ThinkPad
 * @Since 1.0
 */
public class NullPadder implements Padder{
    @Override
    public ISOField pad(ISOField isoField) {
        return isoField;
    }

    @Override
    public ISOField unPad(ISOField isoField) {
        return isoField;
    }
}
