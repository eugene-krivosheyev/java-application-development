package com.acme.dbo.txlog.message;

public class BooleanMessage {
    private final boolean value;
    private final String DECORATION_PREFIX  = "primitive: ";
    private final String DECORATION_POSTFIX = "";


    public BooleanMessage(boolean value) {
        this.value = value;
    }

    public BooleanMessage() {
        this(false);
    }

    public boolean getValue() {
        return value;
    }

    @Override
    public String toString() {
        return DECORATION_PREFIX + value + DECORATION_POSTFIX;
    }

}
