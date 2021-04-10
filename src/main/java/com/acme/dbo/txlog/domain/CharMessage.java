package com.acme.dbo.txlog.domain;

public class CharMessage extends AbstractMessage<Character>{
    char body;

    {
        prefix = "char: ";
    }

    public CharMessage(char message) {
        body = message;
    }

    @Override
    public Message accumulate(Message newMessage) {
        return new CharMessage((Character) newMessage.getBody());
    }

    @Override
    public Character getBody() {
        return body;
    }

    @Override
    public String intermediate() {
        return toString();
    }
}
