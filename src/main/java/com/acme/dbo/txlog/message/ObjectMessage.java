package com.acme.dbo.txlog.message;

public class ObjectMessage {
    private final Object value;
    private final String DECORATION_PREFIX  = "reference: ";
    private final String DECORATION_POSTFIX = "";


    public ObjectMessage(Object value) {
        this.value = value;
    }

    public ObjectMessage() {
        this(new Object());
    }

    public Object getValue() {
        return value;
    }

    @Override
    public String toString() {
        return DECORATION_PREFIX + value.toString() + DECORATION_POSTFIX;
    }
}
