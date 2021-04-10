package com.acme.dbo.txlog.domain;

public interface Message <T>{

    Message<T> accumulate(Message<T> newMessage);

    String getPrefix();

    T getBody();

    String intermediate();

    void clear();

    boolean shouldFlush(Message<T> newMessage);
}
