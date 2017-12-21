package com.tany.jpos.interfaces;

import com.tany.jpos.JPOSException;

public interface MsgPackager {
    /**
     * 解析报文
     * @param b
     * @return
     * @throws JPOSException
     */
    Msg unpack(byte [] b) throws JPOSException;

    /**
     * 报文组包
     * @param msg
     * @return
     * @throws JPOSException
     */
    byte[] pack(Msg msg) throws JPOSException;
}
