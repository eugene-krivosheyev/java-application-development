package com.acme.dbo.txlog.commands;

public class BooleanCommand implements Command {
    public static final String BOOLEAN_DECORATION = "primitive: ";
    private boolean message;

    public BooleanCommand(boolean message) {
        this.message = message;
    }

    public String getMessage() {
        return String.valueOf(message);
    }

    public String getDecoratedMessage() {
        return BOOLEAN_DECORATION + getMessage();
    }

    public Command append(Command commandState) {
        return null;
    }
}
