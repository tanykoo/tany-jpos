package com.tany.jpos;

public class ISOException extends Throwable{
    private String errCode;

    public ISOException(String message,String errCode) {
        super(message + "  ErrCode:" + errCode);
    }

    public ISOException(String message, int fieldno, String errCode) {
        this("拆解报文出错："+ message + "，域号：" + fieldno, errCode);
    }
}
