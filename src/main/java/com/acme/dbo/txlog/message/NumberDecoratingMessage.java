package com.acme.dbo.txlog.message;

public class NumberDecoratingMessage implements DecoratingMessage {
    private final long body;
    protected int maxValue;

    public NumberDecoratingMessage(final long body) {
        this.body = body;
    }

    @Override
    public String getDecoratedMessage() {
        return "primitive: " + body;
    }

    @Override
    public DecoratingMessage accumulate(final DecoratingMessage message) {
        if (!(message instanceof NumberDecoratingMessage)) {
            throw new IllegalArgumentException("Parameter 'message' is not of type " + this.getClass().getTypeName());
        }
        final NumberDecoratingMessage addingMessage = (NumberDecoratingMessage) message;
        if (body + addingMessage.getBody() > maxValue) {
            return message;
        }
        return new NumberDecoratingMessage(body + addingMessage.getBody());
    }

    public long getBody() {
        return this.body;
    }
}
