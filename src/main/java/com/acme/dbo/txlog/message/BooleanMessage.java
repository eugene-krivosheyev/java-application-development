package com.acme.dbo.txlog.message;

import com.acme.dbo.txlog.Message;

public class BooleanMessage implements Message {
    private final boolean message;

    public BooleanMessage(boolean message) {
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
