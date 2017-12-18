package com.tany.jpos;

import com.tany.jpos.interfaces.Padder;
import com.tany.jpos.interfaces.Prefix;

public abstract class BaseISOFieldPackager {
    // 前缀解析器
    protected Prefix prefix;
    // 补位解析器
    protected Padder padder;
    // ISO8583域最大长度
    protected int maxlen;

    public ISOField unPack(byte b[] , int offset) throws ISOException{

        int bodylen = prefix.unpack(b,offset);
        int prefixlen = prefix.getPrefixByteLen();

        return padder.unPad(unPackbody(b, offset + prefixlen , bodylen == Prefix.NOPREFIX ? maxlen : bodylen ));
    }

    protected ISOField unPackbody(byte b[] , int offset, int bodylen)throws ISOException{
        byte [] body = new byte[bodylen];
        System.arraycopy(b,offset, body,0, bodylen);

        ISOField isoField =  unPackbody(body);
        isoField.setLength(prefix.getPrefixByteLen() + bodylen);

        return  isoField;
    }

    /**
     * 根据字段类型解析成字段内容
     * @param b 从报文中截取的字段的字节内容
     * @return  ISO8583域内容
     * @throws ISOException
     */
    protected abstract ISOField unPackbody(byte b[])throws ISOException;

    public byte [] pack(ISOField isoField)throws ISOException{
        isoField = padder.pad(isoField);
        byte [] body = packbody(isoField);
        byte [] bprefix = prefix.pack(body.length);
        byte [] tmp = new byte[body.length + bprefix.length];
        System.arraycopy(bprefix,0, tmp,0, bprefix.length);
        System.arraycopy(body,0, tmp, bprefix.length, body.length);
        return tmp;
    }

    /**
     * 组
     * @param isoField
     * @return
     * @throws ISOException
     */
    protected  abstract  byte [] packbody(ISOField isoField)throws ISOException;
}
