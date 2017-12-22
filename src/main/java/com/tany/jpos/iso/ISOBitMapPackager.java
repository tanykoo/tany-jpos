package com.tany.jpos.iso;

import java.util.BitSet;

/**
 * @Author ThinkPad
 * @Since 1.0
 */
public abstract class ISOBitMapPackager extends ISOFieldContentPackager {

    @Override
    public ISOBitMap unPack(byte[] b) {

        ISOBitMap isoBitMap = new ISOBitMap();
        b = toBitBytes(b);
        isoBitMap.setValue(unPackbody(b));
        isoBitMap.setLength(getLength(b));

        return isoBitMap;
    }

    /**
     * 组包方法
     * @param isoField 位图类型
     * @return 位图的字节数组
     */
    @Override
    protected byte[] pack(ISOField isoField) {
        return this.pack((ISOBitMap) isoField);
    }

    /**
     * 组包 将位图内容组成实际类型的数组
     * @param isoBitMap
     * @return
     */
    private byte[] pack(ISOBitMap isoBitMap) {
        boolean longbit = false;
        BitSet bitSet = isoBitMap.getValue();
        byte[] bitMap = new byte[bitSet.size() >> 3];
        for (int i = 1; i < bitSet.size(); i++) {
            if (bitSet.get(i)) {
                bitMap[i >> 3] |= ((0x01 << (7 - i % 8)) & 0xff);
                if(i >= 64 && !longbit) {
                    longbit = true;
                }
            }
        }
        byte tmp [] ;
        if(!longbit){
            tmp = new byte[64 >> 3];
        }else{
            bitMap[0] |= 1000_0000;
            tmp = new byte[128 >> 3];
        }
        System.arraycopy(bitMap, 0, tmp, 0, tmp.length);
        return toLocalByte(tmp);
    }

    /**
     * 将位字节转换成实际类型的字节数组
     * 不同数据类型的位图需要使用不同的组包方法
     * @see ISOBBitMapPackager
     * @see ISOABitMapPackager
     * @param bitmap 位图的位表示数组
     * @return
     */
    protected abstract byte[] toLocalByte(byte[] bitmap);

    /**
     * 将实际类型的字节数组转换成位字节数组
     * @param bitmap ISO8583报文中截取的位图内容
     * @return
     */
    protected abstract byte[] toBitBytes(byte[] bitmap);

    /**
     * 解析位数组
     * @param b 位数组
     * @return 返回位图的BitSet表示
     * @see BitSet
     */
    private BitSet unPackbody(byte[] b) {
        BitSet bitSet = new BitSet(((b[0] & 0x80) == 0) ? 64 : 128);
        for (int i = 0; i < bitSet.size(); i++) {
            if ((((b[i >> 3] & 0xff ) >> (7 - i % 8)) & 0x01) == 1) {
                bitSet.set(i);
            }
        }
        return bitSet;
    }

}
