package com.acme.dbo.txlog.domain;

public class ObjectMessage extends AbstractMessage<Object> {
    Object body;

    {
        prefix = "reference: ";
    }

    public ObjectMessage(Object message) { body = message; }

    @Override
    public Message accumulate(Message newMessage) {
        return new ObjectMessage( newMessage.getBody());
    }

    @Override
    public Object getBody() {
        return body;
    }

    @Override
    public String intermediate() { return toString(); }


}
