package com.tany.jpos.iso;

/**
 * @Author ThinkPad
 * @Since 1.0
 */
public class DefaultISOFieldPackager extends BaseISOFieldPackager {

    public DefaultISOFieldPackager(int maxlen){
        this("","","",maxlen);
    }

    public DefaultISOFieldPackager(String fieldtype, String padder, String prefixtype, int maxlen){
        super(null, maxlen);
    }

}
