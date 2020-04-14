package com.acme.dbo.txlog;

public class NullCommand implements Command {
    @Override
    public boolean isSame(Command command) {
        return false;
    }

    @Override
    public Command accumulate(Command command) {
        return command;
    }
}
