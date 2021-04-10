package com.acme.dbo.txlog.domain;

public class ByteMessage extends AbstractMessage<Byte> {
    private byte body;

    {
        prefix = "primitive: ";
    }

    public ByteMessage(byte message) {
        body = message;
    }

    @Override
    public Message accumulate(Message newMessage) {
        return new ByteMessage((byte) (body + (Byte) newMessage.getBody()));
    }

    @Override
    public Byte getBody() {
        return body;
    }

    @Override
    public boolean shouldFlush(Message newMessage) {
        byte newBody = (Byte) newMessage.getBody();
        byte result = (byte) (body + newBody);
        if ((result > 0 & body < 0 & newBody < 0) || (result < 0 & body > 0 & newBody > 0)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void clear() {
        body = 0;
    }

}
