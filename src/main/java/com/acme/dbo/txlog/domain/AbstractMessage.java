package com.acme.dbo.txlog.domain;

abstract class AbstractMessage implements Message{
    String prefix;

    @Override
    public String getPrefix() {
        return prefix;
    }

    public boolean shouldFlush(Message newMessage)
    {
        return false;
    }

    @Override
    public String intermediate() {
        return null;
    }

    @Override
    public void clear() {}

}
