package com.acme.dbo.txlog;

public class CommandChar implements Command {
    private Character message;
    private static final String PREFIX_CHAR = "char: ";

    public CommandChar(Character message) {
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
        return PREFIX_CHAR + this.message.toString();
    }
}
