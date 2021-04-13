package com.acme.dbo.txlog.message;


public class IntMessage {
    private final int value;
    private final String DECORATION_PREFIX  = "primitive: ";
    private final String DECORATION_POSTFIX = "";


    public IntMessage(int value) {
        this.value = value;
    }

    public IntMessage() {
        this(0);
    }

    public int getValue() {
        return value;
    }

    public IntMessage accumulate(IntMessage message) {
        return new IntMessage(value + message.getValue());
    }

    @Override
    public String toString() {
        return DECORATION_PREFIX + value + DECORATION_POSTFIX;
    }

    public boolean isNumberOverflow (IntMessage testMessage) {
        return (long) value + (long) testMessage.value > Integer.MAX_VALUE;
    }
}
