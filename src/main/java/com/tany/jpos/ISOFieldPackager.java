package com.tany.jpos;

import com.tany.jpos.interfaces.Padder;
import com.tany.jpos.interfaces.Prefix;

public abstract class ISOFieldPackager {
    //前缀解析器
    protected Prefix prefix;
    //补位解析器
    protected Padder padder;
    //ISO8583域最大长度
    protected int maxlen;

    public ISOField unPack(byte b[] , int offset){

        int bodylen = prefix.unpack(b,offset);
        int prefixlen = prefix.getPrefixLen();

        return padder.unPad(unPackbody(b, offset + prefixlen , bodylen == Prefix.NOPREFIX ? maxlen : bodylen ));
    }

    protected ISOField unPackbody(byte b[] , int offset, int bodylen){
        byte [] body = new byte[bodylen];
        System.arraycopy(b,offset, body,0, bodylen);

        ISOField isoField =  unPackbody(body);
        isoField.setLength(prefix.getPrefixLen() + bodylen);

        return  isoField;
    }

    protected abstract ISOField unPackbody(byte b[]);

    public byte [] pack(ISOField isoField){
        isoField = padder.pad(isoField);
        byte [] body = packbody(isoField);
        byte [] bprefix = prefix.pack(body.length);
        byte [] tmp = new byte[body.length + bprefix.length];
        System.arraycopy(bprefix,0, tmp,0, bprefix.length);
        System.arraycopy(body,0, tmp, bprefix.length, body.length);
        return tmp;
    }

    protected  abstract  byte [] packbody(ISOField isoField);
}
