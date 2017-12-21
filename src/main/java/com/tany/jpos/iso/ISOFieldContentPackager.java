package com.tany.jpos.iso;

import com.tany.jpos.JPOSException;
import com.tany.jpos.interfaces.Field;
import com.tany.jpos.interfaces.FieldContentPackager;

/**
 * ISO字段内容解析器
 * @Author ThinkPad
 * @Since 1.0
 */
public abstract class ISOFieldContentPackager implements FieldContentPackager{
    /**
     * 解包方法
     * @param b 从报文中截取的该域的字节内容
     * @return 域内容
     * @throws ISOException
     */
    @Override
    public abstract ISOField unPack(byte[] b) throws ISOException ;

    /**
     * 组包方法
     * @param field 要组的域内容
     * @return 组包后的字节数组
     * @throws ISOException
     */
    @Override
    public byte[] pack(Field field) throws ISOException {
        return pack((ISOField) field);
    }

    /**
     * 组包方法
     * @param field 要组的域内容
     * @return 组包后的字节数组
     */
    protected abstract byte[] pack(ISOField field);

    /**
     * 获取域的实际长度
     * @param body 从报文中截取的域的内容
     * @return 返回域的实际长度
     */
    public abstract int getLength(byte[] body);
}
