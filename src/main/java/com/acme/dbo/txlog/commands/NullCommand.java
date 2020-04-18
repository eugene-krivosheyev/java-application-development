package com.acme.dbo.txlog.commands;

public class NullCommand implements Command {
    @Override
    public String getDecoratedMessage() {
        return null;
    }

    @Override
    public boolean isSame(Command command) {
        return false;
    }

    @Override
    public boolean validate(Command command) {
        return false;
    }

    @Override
    public void accumulate(Command command) {

    }
}
