package com.acme.dbo.txlog.message;

public class CharMessage implements Message {
    private final String CHAR_PREFIX = "char: ";
    private final String CHAR_POSTFIX = "";

    private final char message;

    public CharMessage(char message) {
        this.message = message;
    }

    public String getDecoratedMessage() {
        return CHAR_PREFIX + message + CHAR_POSTFIX;
    }

    @Override
    public boolean equalType(Message message) {
        return message instanceof CharMessage;
    }

    @Override
    public CharMessage accumulate(Message message) {
        return (CharMessage) message;
    }
}
