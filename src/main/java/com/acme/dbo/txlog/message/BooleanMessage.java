package com.acme.dbo.txlog.message;

public class BooleanMessage implements Message {
    private final boolean value;
    private final String DECORATION_PREFIX  = "primitive: ";
    private final String DECORATION_POSTFIX = "";


    public BooleanMessage(boolean value) {
        this.value = value;
    }

    public BooleanMessage() {
        this(false);
    }

    @Override
    public Object getValue() {
        return value;
    }

    @Override
    public BooleanMessage accumulate(Message message) {
        return new BooleanMessage((boolean) message.getValue());
    }

    @Override
    public String toString() {
        return DECORATION_PREFIX + value + DECORATION_POSTFIX;
    }

    @Override
    public BooleanMessage getDefaultMessage() {
        return new BooleanMessage();
    }

}
