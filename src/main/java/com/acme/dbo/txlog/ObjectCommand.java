package com.acme.dbo.txlog;

public class ObjectCommand {
    private Object message;

    public ObjectCommand(Object message) {
        this.message = message;
    }

    public String getMessage() { return String.valueOf(message); }
    public String getDecoratedMessage() { return "reference: " + getMessage();}

    public boolean process() { return true;}

}
