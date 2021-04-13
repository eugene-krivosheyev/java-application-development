package com.acme.dbo.txlog.message;

public class IntMessage {
    private final String PRIMITIVE_PREFIX = "primitive: ";
    private final String PRIMITIVE_POSTFIX = "";

    private final int message;

    IntMessage(int message) {
        this.message = message;
    }

    public String getDecoratedMessage() {
        return PRIMITIVE_PREFIX + message + PRIMITIVE_POSTFIX;
    }

    public IntMessage accumulate(IntMessage intMessage) {
        return new IntMessage(this.getMessage() + intMessage.getMessage());
    }

    public int getMessage() {
        return message;
    }
}
