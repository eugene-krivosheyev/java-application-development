package com.acme.dbo.txlog.message;

public class ByteMessage extends MessageBase {

    private byte value;

    public ByteMessage(byte value) {
        this.value = value;
    }

    public byte getValue() {
        return value;
    }

    @Override
    public String toString() {
        return Byte.toString(value);
    }
}
