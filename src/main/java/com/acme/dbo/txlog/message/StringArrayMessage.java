package com.acme.dbo.txlog.message;

public class StringArrayMessage {
    private final String[] message;

    StringArrayMessage(String[] message) {
        this.message = message;
    }

    public String[] getMessage() {
        return message;
    }
}
