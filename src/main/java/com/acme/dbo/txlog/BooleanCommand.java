package com.acme.dbo.txlog;

public class BooleanCommand {
    private boolean message;

    public BooleanCommand(boolean message) {
        this.message = message;
    }

    public String getMessage() { return String.valueOf(message); }
    public String getDecoratedMessage() { return "primitive: " + getMessage();}

    public boolean process() { return true;}
}
