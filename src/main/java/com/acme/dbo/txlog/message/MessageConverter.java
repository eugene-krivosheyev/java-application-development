package com.acme.dbo.txlog.message;

public final class MessageConverter {

    private MessageConverter(){}

    public static MessageBase toMessage(byte message) {
        return new ByteMessage(message);
    }

    public static MessageBase toMessage(int message) {
        return new IntMessage(message);
    }

    public static MessageBase toMessage(boolean message) {
        return new BoolMessage(message);
    }

    public static MessageBase toMessage(char message) {
        return new CharMessage(message);
    }

    public static MessageBase toMessage(String message) {
        return new StringMessage(message);
    }

    public static MessageBase toMessage(int[] message) {

        return new ObjectMessage(message);
    }

    public static MessageBase toMessage(Object message) {
        return new ObjectMessage(message);
    }

}
