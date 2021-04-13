package com.acme.dbo.txlog.message;

public class ByteMessage implements Message {
    private final String PRIMITIVE_PREFIX = "primitive: ";
    private final String PRIMITIVE_POSTFIX = "";

    private final byte message;

    public ByteMessage(byte message) {
        this.message = message;
    }

    public byte getMessage() {
        return message;
    }

    public String getDecoratedMessage() {
        return PRIMITIVE_PREFIX + message + PRIMITIVE_POSTFIX;
    }

    @Override
    public boolean equalType(Message message) {
        return message instanceof ByteMessage;
    }

    @Override
    public ByteMessage accumulate(Message message) {
        if (!(message instanceof ByteMessage)) throw new IllegalArgumentException("Message");
        ByteMessage newMessage = (ByteMessage) message;
        return new ByteMessage((byte) (this.getMessage() + newMessage.getMessage()));
    }
}
