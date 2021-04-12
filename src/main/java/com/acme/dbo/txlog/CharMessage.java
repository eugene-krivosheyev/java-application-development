package com.acme.dbo.txlog;

public class CharMessage {
    private final String CHAR_PREFIX = "char: ";
    private final String CHAR_POSTFIX = "";

    private final char message;

    public CharMessage(char message) {
        this.message = message;
    }

    public Object getDecoratedMessage() {
        return CHAR_PREFIX + message + CHAR_POSTFIX;
    }
}
