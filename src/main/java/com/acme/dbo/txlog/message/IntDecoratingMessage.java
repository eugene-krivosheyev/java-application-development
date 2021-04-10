package com.acme.dbo.txlog.message;

public class IntDecoratingMessage implements DecoratingMessage {
    private final long body;

    public IntDecoratingMessage(final long body) {
        this.body = body;
    }

    @Override
    public String getDecoratedMessage() {
        return "primitive: " + body;
    }

    @Override
    public DecoratingMessage accumulate(final DecoratingMessage message) {
        if (!(message instanceof IntDecoratingMessage)) {
            throw new IllegalArgumentException("Parameter 'message' is not of type " + this.getClass().getTypeName());
        }
        final IntDecoratingMessage addingMessage = (IntDecoratingMessage) message;
        if (body + addingMessage.getBody() > Integer.MAX_VALUE) {
            return message;
        }
        return new IntDecoratingMessage(body + addingMessage.getBody());
    }

    @Override
    public Long getBody() {
        return this.body;
    }
}
