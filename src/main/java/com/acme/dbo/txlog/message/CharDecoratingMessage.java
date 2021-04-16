package com.acme.dbo.txlog.message;

public class CharDecoratingMessage extends AbstractDecoratingMessage {
    private static final String PREFIX = "char: ";

    public CharDecoratingMessage(final char body) {
        this.body = body;
        this.prefix = PREFIX;
    }

    @Override
    public boolean isEqualType(DecoratingMessage message) {
        return message instanceof CharDecoratingMessage;
    }
}
