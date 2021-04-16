package com.acme.dbo.txlog.message;

public abstract class AbstractDecoratingMessage implements DecoratingMessage {
    protected String prefix;
    protected Object body;

    @Override
    public DecoratingMessage accumulate(DecoratingMessage message) {
        return message;
    }

    @Override
    public String getDecoratedMessage() {
        return prefix + body;
    }
}
