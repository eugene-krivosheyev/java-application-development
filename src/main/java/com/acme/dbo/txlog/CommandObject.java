package com.acme.dbo.txlog;

public class CommandObject implements Command {
    private Object message;
    private static final String PREFIX_PREFERNCE = "reference: ";

    public CommandObject(Object message) {
        this.message = message;
    }

    @Override
    public Boolean isSame(Command currentState)  {
        return currentState instanceof CommandByte;
    }

    @Override
    public Command updateState(Command command) {
        return null;
    }

    @Override
    public Boolean updateNeeded(Command command) {
        return null;
    }

    @Override
    public String decorate(Command command) {
        return PREFIX_PREFERNCE + this.message.toString();
    }
}
