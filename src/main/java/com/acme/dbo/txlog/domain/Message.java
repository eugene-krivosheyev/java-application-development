package com.acme.dbo.txlog.domain;

public interface Message {

    Message accumulate(Message newMessage);

    String getPrefix();

    String intermediate();

    void clear();

    boolean shouldFlush(Message newMessage);
}
