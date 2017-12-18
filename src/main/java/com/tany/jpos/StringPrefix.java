package com.tany.jpos;

import com.sun.istack.internal.NotNull;
import com.tany.jpos.interfaces.Prefix;

/**
 * @Author ThinkPad
 * @Since 1.0
 */
public class StringPrefix implements Prefix{

    private int plen;

    public StringPrefix(){
        this(NOPREFIX);
    }

    public StringPrefix(int plen){
        this.plen = plen;
    }

    @Override
    public int unpack(byte[] b, int offset) {
        if(plen <= 0){
            throw new ISORuntimeException("配置错误，BCD前缀必须指定前缀长度");
        }
        String prefix = new String(b,offset,getPrefixByteLen());
        if(validity(prefix)){
            return Integer.parseInt(prefix);
        }else
            throw new ISORuntimeException("前缀解析异常,[" + prefix +"]");
    }

    private boolean validity(String str){
        return str.matches("[0-9]*");
    }

    private boolean validity(int len){
        return ("" + len).length() <= plen;
    }
    @Override
    public byte[] pack(int length) {
        if(!validity(length)){
            throw new ISORuntimeException("配置长度不够,前缀长度:" + plen + ", 实际长度:"+ length);
        }
        String tmp = "" + length;
        for(int i = tmp.length(); i < getPrefixByteLen(); i++){
            tmp = "0" + tmp;
        }
        return tmp.getBytes();
    }

    @Override
    public int getPrefixByteLen() {
        return plen;
    }

    @Override
    public void setPrefixLen(int prefixLen) {
        this.plen = prefixLen;
    }
}
