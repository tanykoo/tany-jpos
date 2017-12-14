package com.tany.jpos;

public abstract class ISOField {
    protected  int fieldno;
    protected String type;
    protected Object value;
    private  int length;

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

}
