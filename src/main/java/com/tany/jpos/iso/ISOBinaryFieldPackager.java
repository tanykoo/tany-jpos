package com.tany.jpos.iso;

/**
 * 字段内容为binary 类型的字段内容解析器
 * @Author ThinkPad
 * @Since 1.0
 */
public class ISOBinaryFieldPackager extends ISOFieldContentPackager{
    @Override
    public ISOField unPack(byte[] b) throws ISOException {
        ISOBinaryField isofield = new ISOBinaryField();
        isofield.setValue(b);
        return isofield;
    }

    @Override
    protected byte[] pack(ISOField field) {
        return (byte[]) field.getValue();
    }

    @Override
    public int getLength(byte[] body) {
        return body.length;
    }
}
