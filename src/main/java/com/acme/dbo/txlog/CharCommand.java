package com.acme.dbo.txlog;

public class CharCommand {
    private char message;

    public CharCommand(char message) {
        this.message = message;
    }

    public String getMessage() { return String.valueOf(message); }
    public String getDecoratedMessage() { return "char: " + getMessage();}

    public boolean process() { return true;}

}
