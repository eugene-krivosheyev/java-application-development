package com.acme.dbo.txlog.message;

public class NullMessage implements Message{
    @Override
    public Object getValue() {
        return null;
    }

    @Override
    public Message accumulate(Message message) {
        return message.accumulate(message);
    }

    @Override
    public NullMessage getDefaultMessage() {
        return new NullMessage();
    }

    public String toString() {
        return "";
    }
}
