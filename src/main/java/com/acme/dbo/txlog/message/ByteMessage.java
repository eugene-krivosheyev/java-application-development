package com.acme.dbo.txlog.message;

public class ByteMessage implements Message{
    private final byte value;
    private final String DECORATION_PREFIX  = "primitive: ";
    private final String DECORATION_POSTFIX = "";

    public ByteMessage(byte value) {
        this.value = value;
    }

    public ByteMessage() {this((byte) 0);
    }

    @Override
    public Object getValue() {
        return value;
    }

    @Override
    public ByteMessage accumulate(Message message) {
        return new ByteMessage((byte) ((byte) message.getValue() + value));
    }

    @Override
    public ByteMessage getDefaultMessage() {
        return new ByteMessage();
    }

    @Override
    public String toString() {
        return DECORATION_PREFIX + value + DECORATION_POSTFIX;
    }

    @Override
    public boolean isNumberOverflow (Message testMessage) {
        return (long) value + (Byte) testMessage.getValue() > Byte.MAX_VALUE;
    }

}
