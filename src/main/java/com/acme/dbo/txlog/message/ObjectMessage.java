package com.acme.dbo.txlog.message;

public class ObjectMessage extends MessageBase {

    private Object value;

    public ObjectMessage(Object value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
