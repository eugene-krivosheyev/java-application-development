package com.acme.dbo.txlog.domain;

abstract class AbstractMessage <T> implements Message<T>{
    String prefix;

    @Override
    public String getPrefix() {
        return prefix;
    }

    public String toString(){
        return getPrefix() + getBody().toString();
    }

    public boolean shouldFlush(Message<T> newMessage)
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
