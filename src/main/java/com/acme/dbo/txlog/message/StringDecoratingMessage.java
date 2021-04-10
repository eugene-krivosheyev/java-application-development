package com.acme.dbo.txlog.message;

public class StringDecoratingMessage implements DecoratingMessage {
    private final String body;

    public StringDecoratingMessage(final String body) {
        this.body = body;
    }

    @Override
    public String getDecoratedMessage() {
        return "string: " + body;
    }

    @Override
    public DecoratingMessage accumulate(DecoratingMessage message) {
        return null;
    }
}
