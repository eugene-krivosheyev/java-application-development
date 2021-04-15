package com.acme.dbo.txlog.message;

public class ObjectMessage implements Message {
    private final Object value;
    private final String DECORATION_PREFIX  = "reference: ";
    private final String DECORATION_POSTFIX = "";


    public ObjectMessage(Object value) {
        this.value = value;
    }

    public ObjectMessage() {
        this(new Object());
    }

    @Override
    public Object getValue() {
        return value;
    }

    @Override
    public ObjectMessage accumulate(Message message) {
        return new ObjectMessage(message.getValue());
    }

    @Override
    public String toString() {
        return DECORATION_PREFIX + value.toString() + DECORATION_POSTFIX;
    }

    @Override
    public ObjectMessage getDefaultMessage() {
        return new ObjectMessage();
    }
}
