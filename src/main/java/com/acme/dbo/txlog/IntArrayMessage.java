package com.acme.dbo.txlog;

public class IntArrayMessage {
    private final int[] message;

    public IntArrayMessage(int[] message) {
        this.message = message;
    }

    public int[] getMessage() {
        return message;
    }
}
