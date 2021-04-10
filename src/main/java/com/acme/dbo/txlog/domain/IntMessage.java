package com.acme.dbo.txlog.domain;

public class IntMessage extends AbstractMessage<Integer> {
    private int body;

    {
        prefix = "primitive: ";
    }

    public IntMessage(int message) {
        body = message;
    }

    public IntMessage accumulate(Message newMessage) {
        return new IntMessage((Integer) newMessage.getBody() + body);
    }

    @Override
    public Integer getBody() {
        return body;
    }

    @Override
    public boolean shouldFlush(Message newMessage) {
        int newBody = (Integer) newMessage.getBody();
        int result = body + newBody;
        return (result > 0 & body < 0 & newBody < 0) || (result < 0 & body > 0 & newBody > 0);
    }

    @Override
    public void clear() {
        body = 0;
    }

}
