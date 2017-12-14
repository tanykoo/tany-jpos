package com.tany.jpos;

public class ISOException extends Throwable{
    private String errCode;

    public ISOException(String message,String errCode) {
        message=""+message;

    }
}
