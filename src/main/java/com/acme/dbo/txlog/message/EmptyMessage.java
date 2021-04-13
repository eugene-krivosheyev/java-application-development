package com.acme.dbo.txlog.message;

import com.acme.dbo.txlog.Message;

public class EmptyMessage implements Message {

    public EmptyMessage() {
    }

    @Override
    public String getDecoratedMessage() {
        return "";
    }

    @Override
    public void accumulate(Message message) {
    }
}
