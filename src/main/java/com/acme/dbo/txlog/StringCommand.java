package com.acme.dbo.txlog;

public class StringCommand {
    private String message;
    private int count;

    public StringCommand(String message) {
        this.message = message;
        count = 1;
    }

    private StringCommand(String message, int count) {
        this.message = message;
        this.count = count;
    }

    public String getMessage() { return message + (count > 1 ? (" (x" + count + ")") : ""); }
    public String getDecoratedMessage() { return "string: " + getMessage();}
    public StringCommand process(StringCommand prevCommand) {
        if (prevCommand != null && !prevCommand.message.equals(message)) {
            return null;
        } if (prevCommand != null) {
            return new StringCommand(message, prevCommand.count + 1);
        } else {
            return this;
        }
    }
}
