package com.acme.dbo.txlog.message;

public class BooleanMessage implements Message {
    private final String PRIMITIVE_PREFIX = "primitive: ";
    private final String PRIMITIVE_POSTFIX = "";

    private boolean message;

    public BooleanMessage(boolean message) {
        this.message = message;
    }

    public String getDecoratedMessage() {
        return PRIMITIVE_PREFIX + message + PRIMITIVE_POSTFIX;
    }

    @Override
    public boolean equalType(Message message) {
        return message instanceof BooleanMessage;
    }

    @Override
    public BooleanMessage accumulate(Message message) {
        return (BooleanMessage) message;
    }
}
