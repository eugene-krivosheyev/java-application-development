package com.acme.dbo.command;


public class NullCommand implements Command {
    private String message;

    public NullCommand()    {
        this.message = null;
    }

    @Override
    public String decoratedMessage() {
        return null;
    }

    @Override
    public Command accumulateCommand(Command command) {
        return null;
    }

    @Override
    public boolean isSame(Command command) {
        return false;
    }

    public boolean checkOverflow(Command command) {
        return false;
    }
}
