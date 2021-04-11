package com.acme.dbo.txlog.message;

public class NumberDecoratingMessage implements DecoratingMessage {
    private final long body;
    private final int maxValue;

    public NumberDecoratingMessage(final long body, final int maxValue) {
        this.body = body;
        this.maxValue = maxValue;
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
        if (body + addingMessage.getBody() > this.maxValue) {
            return message;
        }
        return new NumberDecoratingMessage(body + addingMessage.getBody(), this.maxValue);
    }

    @Override
    public Long getBody() {
        return this.body;
    }
}
