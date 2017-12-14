package com.tany.jpos;

/**
 * @Author ThinkPad
 * @Since 1.0
 */
public class DefaultISOFieldPackager extends ISOFieldPackager {

    public DefaultISOFieldPackager(int maxlen){
        this("","","",maxlen);
    }

    public DefaultISOFieldPackager(String fieldtype, String padder, String prefixtype, int maxlen){

        this.maxlen = maxlen;
    }

    @Override
    protected ISOField unPackbody(byte[] b) {
        return null;
    }

    @Override
    protected byte[] packbody(ISOField isoField) {
        return new byte[0];
    }
}
