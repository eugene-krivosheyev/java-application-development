package com.acme.dbo.txlog.commands;

abstract public class BaseCommand implements Command {

    abstract protected String getDecorator();
    public String getDecoratedMessage() {
        return getDecorator() + getMessage();
    }

    @Override
    public boolean shouldAppend(Command state) {
        return false;
    }

    public Command append(Command state) {
        return null;
    }
}
