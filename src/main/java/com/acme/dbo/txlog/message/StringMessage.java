package com.acme.dbo.txlog.message;

public class StringMessage extends MessageBase {

    private String value;

    public StringMessage(String value){
        this.value = value;
    }

    @Override
    public String toString(){
        return value;
    }
}
