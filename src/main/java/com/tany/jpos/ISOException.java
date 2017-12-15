package com.tany.jpos;


public class ISOException extends Throwable{
    private String errCode;

    public ISOException(String message, String errCode) {
        this(message + "  ErrCode:" + errCode);
    }

    public ISOException(String message, int fieldno, String errCode) {
        this("拆解报文出错："+ message + "，域号：" + fieldno, errCode);
    }
    public ISOException(String message){
        super(message);
    }
}
