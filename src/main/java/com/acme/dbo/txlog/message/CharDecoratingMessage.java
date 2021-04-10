package com.acme.dbo.txlog.message;

public class CharDecoratingMessage implements DecoratingMessage {
    private final char body;

    public CharDecoratingMessage(final char body) {
        this.body = body;
    }

    @Override
    public String getDecoratedMessage() {
        return "char: " + body;
    }

    public char getBody() {
        return this.body;
    }
}
