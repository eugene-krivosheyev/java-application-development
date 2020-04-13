package com.acme.dbo.txlog.commands;

public class CharCommand implements Command {
    public static final String CHAR_DECORATION = "char: ";
    private char message;

    public CharCommand(char message) {
        this.message = message;
    }

    public String getMessage() {
        return String.valueOf(message);
    }

    public String getDecoratedMessage() {
        return CHAR_DECORATION + getMessage();
    }

    @Override
    public boolean shouldAppend(Command state) {
        return false;
    }

    public Command append(Command state) {
        return null;
    }

}
