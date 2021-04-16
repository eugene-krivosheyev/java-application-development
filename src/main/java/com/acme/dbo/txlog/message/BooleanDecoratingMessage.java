package com.acme.dbo.txlog.message;

public class BooleanDecoratingMessage extends AbstractDecoratingMessage {
    private static final String PREFIX = "primitive: ";

    public BooleanDecoratingMessage(final boolean body) {
        this.body = body;
        this.prefix = PREFIX;
    }

    @Override
    public boolean isEqualType(DecoratingMessage message) {
        return message instanceof BooleanDecoratingMessage;
    }
}
