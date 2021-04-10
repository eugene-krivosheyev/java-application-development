package com.acme.dbo.txlog.message;

public class BooleanDecoratingMessage implements DecoratingMessage {
    public static final String PREFIX = "primitive: ";
    private final boolean body;

    public BooleanDecoratingMessage(final boolean body) {
        this.body = body;
    }

    @Override
    public String getDecoratedMessage() {
        return PREFIX + body;
    }

    @Override
    public Boolean getBody() {
        return this.body;
    }
}
