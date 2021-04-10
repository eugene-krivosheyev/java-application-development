package com.acme.dbo.txlog.message;

public class ByteDecoratingMessage implements DecoratingMessage {
    private final long body;

    public ByteDecoratingMessage(final long body) {
        this.body = body;
    }

    @Override
    public String getDecoratedMessage() {
        return "primitive: " + body;
    }

    @Override
    public DecoratingMessage accumulate(final DecoratingMessage message) {
        if (!(message instanceof ByteDecoratingMessage)) {
            throw new IllegalArgumentException("Parameter 'message' is not of type " + this.getClass().getTypeName());
        }
        final ByteDecoratingMessage addingMessage = (ByteDecoratingMessage) message;
        if (body + addingMessage.getBody() > Byte.MAX_VALUE) {
            return message;
        }
        return new ByteDecoratingMessage(body + addingMessage.getBody());
    }

    public long getBody() {
        return this.body;
    }
}
