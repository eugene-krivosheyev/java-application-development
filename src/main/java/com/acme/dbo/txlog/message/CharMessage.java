package com.acme.dbo.txlog.message;

import com.acme.dbo.txlog.Message;

public class CharMessage implements Message {
    private final char message;

    public CharMessage(char message) {
        this.message = message;
    }

    @Override
    public String getDecoratedMessage() {
        return "char: " + message;
    }

    @Override
    public void accumulate(Message message) {

    }
}
