package com.tany.jpos.iso;

import com.tany.jpos.interfaces.Field;

public abstract class ISOField implements Field{
    protected  int fieldno;
    protected String type;
    protected Object value;
    private  int length;
    private String prefix;

    public abstract Object getValue();

    public String getType(){
        return type;
    }

    public int getFieldno(){
        return fieldno;
    }
    public  int getLength(){
        return length;
    }
    public void setLength(int length){
        this.length = length;
    }
    public void setValue(Object value){
        this.value = value;
    }

    public String getPrefix(){
        return prefix;
    }
    public void setPrefix(String prefix){
        this.prefix = prefix;
    }

    public abstract String toString();
}
