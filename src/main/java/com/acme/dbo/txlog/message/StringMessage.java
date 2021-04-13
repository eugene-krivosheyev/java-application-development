package com.acme.dbo.txlog.message;

public class StringMessage {
    private final String STRING_PREFIX = "string: ";
    private final String STRING_POSTFIX = "";

    private int stringCounter = 1;
    private final String message;

    StringMessage(String message) {
        this.message = message;
    }

    public String getDecoratedMessage() {
        return STRING_PREFIX + getStringDependingOnCounter() + STRING_POSTFIX;
    }

    public String getStringDependingOnCounter() {
        if (stringCounter == 1) {
            return message;
        } else {
            return message + " (x" + stringCounter + ")";
        }
    }

    public String getMessage() {
        return message;
    }

    public void incrementCounter() {
        stringCounter++;
    }

    public boolean messageEquals(StringMessage stringMessage) {
        return this.getMessage().equals(stringMessage.getMessage());
    }
}
