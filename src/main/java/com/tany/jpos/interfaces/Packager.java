package com.tany.jpos.interfaces;

import com.tany.jpos.ISOException;

public interface Packager {
    /**
     * 解析报文
     * @param b
     * @return
     * @throws ISOException
     */
    Msg unpack(byte [] b) throws ISOException;

    /**
     * 报文组包
     * @param msg
     * @return
     * @throws ISOException
     */
    byte[] pack(Msg msg) throws ISOException;
}
