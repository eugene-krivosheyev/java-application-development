package com.acme.dbo.txlog.message;


import com.acme.dbo.txlog.message.MessageBase;

public class BoolMessage extends MessageBase {

    private Boolean value;

    public BoolMessage(Boolean value){
        this.value = value;
    }

    @Override
    public String toString(){
        return Boolean.toString(value);
    }
}
