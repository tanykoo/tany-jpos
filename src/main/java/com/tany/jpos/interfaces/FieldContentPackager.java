package com.tany.jpos.interfaces;

import com.tany.jpos.JPOSException;

/**
 * 字段内容解析器
 * @Author ThinkPad
 * @Since 1.0
 */
public interface FieldContentPackager {
    Field unPack(byte[] b) throws JPOSException;
    byte[] pack(Field field) throws JPOSException;
}
