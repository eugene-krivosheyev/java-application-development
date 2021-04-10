package com.acme.dbo.txlog.message;

public class ReferenceDecoratingMessage implements DecoratingMessage {
    public static final String PREFIX = "reference: ";
    private final Object body;

    public ReferenceDecoratingMessage(final Object body) {
        this.body = body;
    }

    @Override
    public String getDecoratedMessage() {
        return PREFIX + body;
    }

    @Override
    public Object getBody() {
        return this.body;
    }
}
