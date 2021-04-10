package com.acme.dbo.txlog.message;

public class ByteDecoratingMessage extends NumberDecoratingMessage {
    public ByteDecoratingMessage(final long body) {
        super(body);
        this.maxValue = Byte.MAX_VALUE;
    }
}
