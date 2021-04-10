package com.acme.dbo.txlog.domain;

public class StringMessage extends AbstractMessage {
    private String body;
    private int repeats;

    {
        prefix = "string: ";
    }

    public StringMessage(String message) {
        body = message;
        this.repeats = 1;
    }

    private StringMessage(String message, int repeats) {
        body = message;
        this.repeats = repeats;
    }

    @Override
    public Message accumulate(Message newMessage) {
        repeats++;
        return new StringMessage(((StringMessage)newMessage).getBody().toString(), repeats);
    }

    public String getBody() {
        return body;
    }

    @Override
    public boolean shouldFlush(Message newMessage) {
        if (((StringMessage)newMessage).getBody() == body) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void clear() {
        body = "";
        repeats = 0;
    }

    @Override
    public String toString() {
        if (repeats == 1) {
            return getPrefix() + getBody();
        } else {
            return getPrefix() + getBody() + " (x" + repeats + ")";
        }
    }

}
