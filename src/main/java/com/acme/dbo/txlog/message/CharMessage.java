package com.acme.dbo.txlog.message;

public class CharMessage implements Message {
    private final char value;
    private final String DECORATION_PREFIX  = "char: ";
    private final String DECORATION_POSTFIX = "";


    public CharMessage(char value) {
        this.value = value;
    }

    public CharMessage() {
        this((char) 0);
    }

    @Override
    public Object getValue() {
        return value;
    }

    @Override
    public CharMessage accumulate(Message message) {
        return new CharMessage((char) (value + (char) message.getValue()));
    }

    @Override
    public String toString() {
        return DECORATION_PREFIX + value + DECORATION_POSTFIX;
    }

    @Override
    public CharMessage getDefaultMessage() {
        return new CharMessage();
    }
}
