package com.acme.dbo.txlog.message;

public class IntMessage implements Message {
    private final String PRIMITIVE_PREFIX = "primitive: ";
    private final String PRIMITIVE_POSTFIX = "";

    private final int message;

    public IntMessage(int message) {
        this.message = message;
    }

    @Override
    public String getDecoratedMessage() {
        return PRIMITIVE_PREFIX + message + PRIMITIVE_POSTFIX;
    }

    @Override
    public boolean equalType(Message message) {
        return message instanceof IntMessage;
    }

    @Override
    public IntMessage accumulate(Message intMessage) {
        if (!(intMessage instanceof IntMessage)) throw new IllegalArgumentException("Message");
        IntMessage newMessage = (IntMessage) intMessage;
        return new IntMessage(this.getMessage() + newMessage.getMessage());
    }

    public int getMessage() {
        return message;
    }
}
