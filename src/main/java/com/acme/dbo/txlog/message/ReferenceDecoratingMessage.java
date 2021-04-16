package com.acme.dbo.txlog.message;

public class ReferenceDecoratingMessage extends AbstractDecoratingMessage {
    private static final String PREFIX = "reference: ";

    public ReferenceDecoratingMessage(final Object body) {
        this.body = body;
        this.prefix = PREFIX;
    }

    @Override
    public boolean isEqualType(DecoratingMessage message) {
        return message instanceof ReferenceDecoratingMessage;
    }
}
