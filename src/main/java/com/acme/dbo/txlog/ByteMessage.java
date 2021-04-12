package com.acme.dbo.txlog;

public class ByteMessage {
    private final String PRIMITIVE_PREFIX = "primitive: ";
    private final String PRIMITIVE_POSTFIX = "";

    private final byte message;

    public ByteMessage(byte message) {
        this.message = message;
    }

    public byte getMessage() {
        return message;
    }

    public ByteMessage accumulate(ByteMessage byteMessage) {
        return new ByteMessage((byte) (this.getMessage() + byteMessage.getMessage()));
    }

    public Object getDecoratedMessage() {
        return PRIMITIVE_PREFIX + message + PRIMITIVE_POSTFIX;
    }
}
