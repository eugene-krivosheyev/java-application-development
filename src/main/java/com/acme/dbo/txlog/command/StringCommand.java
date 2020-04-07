package com.acme.dbo.txlog.command;

public class StringCommand {
    private String message;

    public StringCommand(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }

    public boolean isCumulative(StringCommand value) {
        return message.equals(value.message);
    }
}
