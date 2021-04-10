package com.acme.dbo.txlog.message;

public class ByteDecoratingMessage implements DecoratingMessage {
    private final int body;

    public ByteDecoratingMessage(final int body) {
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

    @Override
    public Integer getBody() {
        return this.body;
    }
}
