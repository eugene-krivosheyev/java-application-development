package com.acme.dbo.txlog.message;

public class CharMessage {
    private final char value;
    private final String DECORATION_PREFIX  = "char: ";
    private final String DECORATION_POSTFIX = "";


    public CharMessage(char value) {
        this.value = value;
    }

    public CharMessage() {
        this((char) 0);
    }

    public char getValue() {
        return value;
    }

    public CharMessage accumulate(CharMessage message) {
        return new CharMessage((char) (value + message.getValue()));
    }

    @Override
    public String toString() {
        return DECORATION_PREFIX + value + DECORATION_POSTFIX;
    }
}
