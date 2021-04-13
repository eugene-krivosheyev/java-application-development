package com.acme.dbo.txlog.message;

import com.acme.dbo.txlog.Message;

public class ReferenceMessage implements Message {
    private final Object message;

    public ReferenceMessage(Object message) {
        this.message = message;
    }

    @Override
    public String getDecoratedMessage() {
        return "reference: " + message;
    }

    @Override
    public void accumulate(Message message) {

    }
}
