package com.acme.dbo.txlog.command;

public class BoolCommand {
    boolean message;

    public BoolCommand(boolean message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return String.valueOf(message);
    }
}
