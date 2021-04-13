package com.acme.dbo.txlog.message;

public class ByteMessage {
    private final byte value;
    private final String DECORATION_PREFIX  = "primitive: ";
    private final String DECORATION_POSTFIX = "";

    public ByteMessage(byte value) {
        this.value = value;
    }

    public ByteMessage() {this((byte) 0);
    }

    public byte getValue() {
        return value;
    }

    public ByteMessage accumulate(ByteMessage message) {
        return new ByteMessage((byte) (message.getValue() + value));
    }

    @Override
    public String toString() {
        return DECORATION_PREFIX + value + DECORATION_POSTFIX;
    }

    public boolean isNumberOverflow (ByteMessage testMessage) {
        return (long) value + (long) testMessage.value > Byte.MAX_VALUE;
    }

}
