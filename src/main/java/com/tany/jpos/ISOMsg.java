package com.tany.jpos;

import com.tany.jpos.interfaces.Msg;

import java.util.Hashtable;

public class ISOMsg implements Msg {
    private ISOField []  head ;
    private Hashtable<Integer,ISOField> body;

    public ISOField[] getHead() {
        return head;
    }

    public Hashtable<Integer, ISOField> getBody() {
        return body;
    }

    public Object getBodyValue(int fieldno){
        if(body.get(fieldno) != null){
            return body.get(fieldno).getValue();
        }
        return null;
    }

    public Object getHeadValue(int fieldno){
        return head.length >= fieldno ? head[fieldno-1].getValue(): null;
    }

    public void setHead(ISOField [] head){
        this.head = head;
    }

    public void addBody(ISOField isoField){
        if(body.contains(isoField.getFieldno())){
            throw new ISORuntimeException("该消息已存在[" + isoField + "]域信息" );
        }
        body.put(isoField.getFieldno(),isoField);
    }

    public void setBody(ISOField isoField){
        body.put(isoField.getFieldno(),isoField);
    }
}
