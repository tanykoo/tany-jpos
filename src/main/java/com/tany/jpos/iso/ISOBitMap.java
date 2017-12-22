package com.tany.jpos.iso;

import com.tany.jpos.iso.ISOField;

import java.util.BitSet;

/**
 * 位图
 * @see BitSet
 * @Author ThinkPad
 * @Since 1.0
 */
public class ISOBitMap extends ISOField {

    /**
     * @see ISOBitMap#YES 表示某个域存在
     */
    public static final String YES = "1";
    /**
     * @see ISOBitMap#NO 表示某个域不存在
     */
    public static final String NO = "0";

    {
        type="bitmap";
    }

    public ISOBitMap(){
        value = new BitSet(128);
    }
    @Override
    public BitSet getValue() {
        return (BitSet) value;
    }

    @Override
    public String toString() {
        String tmp = "";
        for(int i = 0; i < getValue().size(); i++){
            if(getValue().get(i)){
                tmp += YES;
            }else{
                tmp += NO;
            }
        }
        return tmp;
    }

    /**
     * 将某个域设置为存在
     * @param n ISO8583报文域号
     */
    public void setYes(int n){
        ((BitSet)value).set(n, true);
    }

    /**
     * 将某个域设置为不存在
     * @param n ISO8583报文域号
     */
    public void setNo(int n){
        ((BitSet)value).set(n, false);
    }
}
