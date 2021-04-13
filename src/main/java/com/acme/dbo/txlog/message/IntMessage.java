package com.acme.dbo.txlog.message;

import com.acme.dbo.txlog.Message;

public class IntMessage implements Message {
    private final int message;

    public IntMessage(int message) {
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
