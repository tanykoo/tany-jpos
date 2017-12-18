package com.tany.jpos;

import com.tany.jpos.interfaces.Prefix;
import com.tany.jpos.util.StringUtils;

/**
 * @Author ThinkPad
 * @Since 1.0
 */
public class BCDPrefix implements Prefix{

    private int plen ;

    public BCDPrefix(){
        this(NOPREFIX);
    }

    public BCDPrefix(int len){
        this.plen = len;
    }

    @Override
    public int unpack(byte[] b, int offset) {
        if(plen <= 0){
            throw new ISORuntimeException("配置错误，BCD前缀必须指定前缀长度");
        }
        byte [] tmp = new byte[getPrefixByteLen()];
        System.arraycopy(b, offset, tmp, 0, getPrefixByteLen());

        int len = 0;
        String hex = StringUtils.byte2hex(tmp);
        if(hex.matches("[0-9]*")){
            len =  Integer.parseInt(hex);
        }else{
            throw new ISORuntimeException("解析错误，BCD前缀解析失败：[" + hex +"]");
        }

        if(validity(len)){
            return len;
        }else{
            throw new ISORuntimeException("解析异常，前缀配置长度为：" + plen +",解析字段前缀长度为:" + len);
        }
    }

    @Override
    public byte[] pack(int length) {
        if(!validity(length)){
            throw new ISORuntimeException("前缀长度过长，length：" + length + "  前缀要求长度：" + plen);
        }
        byte [] b = new byte[getPrefixByteLen()];
        byte [] tmp = StringUtils.hex2byte("" + length);
        System.arraycopy(tmp,0, b, b.length - tmp.length, tmp.length);
        return b;
    }

    private boolean validity(int length){
        return (length+"").length() <= plen;
    }

    @Override
    public int getPrefixByteLen() {
        return (plen + 1)/2;
    }

    @Override
    public void setPrefixLen(int prefixLen) {
        this.plen = prefixLen;
    }
}
