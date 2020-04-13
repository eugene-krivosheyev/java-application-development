package com.acme.dbo.txlog;

public class CommandBoolean implements Command {
    private Boolean message;
    private static final String PREFIX_PRIMITIVE = "primitive: ";

    public CommandBoolean(Boolean message) {
        this.message = message;
    }

    @Override
    public Boolean isSame(Command currentState) {
        return currentState instanceof CommandByte;
    }

    @Override
    public Command updateState(Command command) {
        return null;
    }

    @Override
    public Boolean updateNeeded(Command command) {
        return false;
    }

    @Override
    public String decorate(Command command) {
        return PREFIX_PRIMITIVE + this.message.toString();
    }
}
