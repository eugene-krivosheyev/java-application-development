package com.acme.dbo.txlog;

public interface Message {
    String getDecoratedMessage();

    void accumulate(Message message);
}
