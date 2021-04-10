package com.acme.dbo.txlog.domain;

public class BooleanMessage extends AbstractMessage<Boolean> {
    Boolean body;

    {
        prefix = "primitive: ";
    }

    public BooleanMessage(boolean message) {
        body = message;
    }

    @Override
    public Message accumulate(Message newMessage) {
        return new BooleanMessage((Boolean) newMessage.getBody());
    }

    @Override
    public Boolean getBody() {
        return body;
    }

    @Override
    public String intermediate() {
        return toString();
    }

}
