package com.acme.dbo.txlog.message;

import com.acme.dbo.txlog.message.MessageBase;

public class ObjectMessage extends MessageBase {

    private Object value;

    public ObjectMessage(Object value){
        this.value = value;
    }

    @Override
    public String toString(){
        return value.toString();
    }
}
