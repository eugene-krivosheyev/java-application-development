package com.acme.dbo.txlog.message;

import com.acme.dbo.txlog.Message;

public class ByteMessage implements Message {
    private final byte message;

    public ByteMessage(byte message) {
        this.message = message;
    }

    @Override
    public String getDecoratedMessage() {
        return "primitive: " + message;
    }

    @Override
    public void accumulate(Message message) {

    }
}
