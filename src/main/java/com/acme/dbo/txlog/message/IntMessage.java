package com.acme.dbo.txlog.message;


public class IntMessage implements Message {
    private final int value;
    private final String DECORATION_PREFIX  = "primitive: ";
    private final String DECORATION_POSTFIX = "";


    public IntMessage(int value) {
        this.value = value;
    }

    public IntMessage() {
        this(0);
    }

    @Override
    public IntMessage getDefaultMessage() {
        return new IntMessage();
    }

    @Override
    public Object getValue() {
        return value;
    }

    @Override
    public IntMessage accumulate(Message message) {
        return new IntMessage(value + (int) message.getValue());
    }

    @Override
    public String toString() {
        return DECORATION_PREFIX + value + DECORATION_POSTFIX;
    }

    public boolean isNumberOverflow (Message testMessage) {
        return (long) value + ((Integer) testMessage.getValue()).intValue() > Integer.MAX_VALUE;
    }
}
