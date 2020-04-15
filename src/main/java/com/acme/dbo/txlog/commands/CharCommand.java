package com.acme.dbo.txlog.commands;

public class CharCommand extends BaseCommand {
    public static final String CHAR_DECORATION = "char: ";
    private char message;

    public CharCommand(char message) {
        this.message = message;
    }
    protected String getDecorator(){
        return CHAR_DECORATION;
    }
    public String getMessage() {
        return String.valueOf(message);
    }
}
