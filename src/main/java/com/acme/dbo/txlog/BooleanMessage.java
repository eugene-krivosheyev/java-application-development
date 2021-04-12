package com.acme.dbo.txlog;

public class BooleanMessage {
    private final String PRIMITIVE_PREFIX = "primitive: ";
    private final String PRIMITIVE_POSTFIX = "";

    private boolean message;

    public BooleanMessage(boolean message) {
        this.message = message;
    }

    public String getDecoratedMessage() {
        return PRIMITIVE_PREFIX + message + PRIMITIVE_POSTFIX;
    }
}
