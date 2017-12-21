package com.tany.jpos.iso;

import com.tany.jpos.JPOSException;
import com.tany.jpos.NullPadder;
import com.tany.jpos.NullPrefix;
import com.tany.jpos.interfaces.Padder;
import com.tany.jpos.interfaces.Prefix;

import javax.print.attribute.standard.MediaSize;

/**
 * 字段解析器
 * <p>ISO8583报文域的组成主要有 前缀<link>Prefix</link> 补位<link>Padder</link> 以及内容
 * 所以一个域的解析需要有前缀解析器  补位解析器 内容解析器三个部分组成，对于变长域报文需要指定域的最大长度
 * 当域长度超限时，抛出异常</p>
 * @see ISOFieldContentPackager
 * @see Prefix
 * @see Padder
 * @author Tany
 * @since 1.0
 */
public class BaseISOFieldPackager {
    // 前缀解析器
    private Prefix prefix;
    // 补位解析器
    private Padder padder;
    //内容解析器
    private ISOFieldContentPackager contentPackager;
    // ISO8583域最大长度
    private int maxlen;

    public void setPrefix(Prefix prefix) {
        this.prefix = prefix;
    }

    public void setPadder(Padder padder) {
        this.padder = padder;
    }

    public void setContentPackager(ISOFieldContentPackager contentPackager) {
        this.contentPackager = contentPackager;
    }

    public void setMaxlen(int maxlen) {
        this.maxlen = maxlen;
    }

    public Prefix getPrefix() {
        return prefix;
    }

    public Padder getPadder() {
        return padder;
    }

    public ISOFieldContentPackager getContentPackager() {
        return contentPackager;
    }

    public int getMaxlen() {
        return maxlen;
    }

    public BaseISOFieldPackager(ISOFieldContentPackager contentPackager, int maxlen){
        this(contentPackager, Prefix.NULL_PREFIX, Padder.NULL_PADDER, maxlen);
    }

    public BaseISOFieldPackager(ISOFieldContentPackager contentPackager,Padder padder, int maxlen){
        this(contentPackager, Prefix.NULL_PREFIX, padder, maxlen);
    }

    public BaseISOFieldPackager(ISOFieldContentPackager contentPackager,Prefix prefix, int maxlen){
        this(contentPackager, prefix, Padder.NULL_PADDER, maxlen);
    }

    public BaseISOFieldPackager(ISOFieldContentPackager contentPackager,Prefix prefix,Padder padder, int maxlen){
        this.prefix = prefix;
        this.padder = padder;
        this.contentPackager = contentPackager;
        this.maxlen = maxlen;
    }

    /**
     * 解包函数
     * 解析接下来的一个域内容
     * @param b ISO8583Msg 的字节内容
     * @param offset 该域的偏移量
     * @return 域内容
     * @throws ISOException
     */
    public ISOField unPack(byte b[] , int offset) throws ISOException{

        ISOField isoField = null;
        int bodylen = prefix.unpack(b,offset);
        int prefixlen = prefix.getPrefixByteLen();

        if(bodylen > maxlen){
            throw new ISOException("域长度超限,最大长度：" + maxlen + " 实际解析长度" + bodylen);
        }
        try {
            isoField = unPackbody(b, offset + prefixlen , bodylen == Prefix.NOPREFIX ? maxlen : bodylen );
            isoField.setPrefix(bodylen + "");
            return padder.unPad(isoField, maxlen);
        } catch (JPOSException e) {
            throw new ISOException(e.getMessage());
        }
    }

    /**
     * 解析一个字段的内容
     * @see BaseISOFieldPackager#unPack
     * @param b ISO8583Msg 内容
     * @param offset 解析到该字段的偏移量
     * @param bodylen 该域的长度
     * @return 域内容
     * @throws ISOException
     */
    private ISOField unPackbody(byte b[] , int offset, int bodylen)throws ISOException{
        if(contentPackager instanceof ISOBitMapPackager){
            bodylen = contentPackager.getLength(b);
        }
        byte [] body = new byte[bodylen];
        System.arraycopy(b,offset, body,0, bodylen);

        ISOField isoField =  contentPackager.unPack(body);
        isoField.setLength(prefix.getPrefixByteLen() + contentPackager.getLength(body));

        return  isoField;
    }

    public byte [] pack(ISOField isoField)throws ISOException{
        try {
            isoField = padder.pad(isoField, maxlen);
        } catch (JPOSException e) {
            throw new ISOException(e.getMessage());
        }
        byte [] body = contentPackager.pack(isoField);
        byte [] bprefix = prefix.pack(body.length);
        byte [] tmp = new byte[body.length + bprefix.length];
        System.arraycopy(bprefix,0, tmp,0, bprefix.length);
        System.arraycopy(body,0, tmp, bprefix.length, body.length);
        return tmp;
    }

}
