package com.acme.dbo.txlog.message;

public class ObjectMessage {
    private final String OBJECT_PREFIX = "reference: ";
    private final String OBJECT_POSTFIX = "";

    private final Object message;

    ObjectMessage(Object message) {
        this.message = message;
    }

    public Object getDecoratedMessage() {
        return OBJECT_PREFIX + message + OBJECT_POSTFIX;
    }
}
