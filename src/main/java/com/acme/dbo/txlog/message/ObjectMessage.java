package com.acme.dbo.txlog.message;

public class ObjectMessage implements Message {
    private final String OBJECT_PREFIX = "reference: ";
    private final String OBJECT_POSTFIX = "";

    private final Object message;

    public ObjectMessage(Object message) {
        this.message = message;
    }

    public String getDecoratedMessage() {
        return OBJECT_PREFIX + message + OBJECT_POSTFIX;
    }

    @Override
    public boolean equalType(Message message) {
        return message instanceof ObjectMessage;
    }

    @Override
    public ObjectMessage accumulate(Message message) {
        return (ObjectMessage) message;
    }
}
