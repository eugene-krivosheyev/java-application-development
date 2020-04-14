package com.acme.dbo.txlog;

abstract public class NumberCommand implements Command {
    protected final int message;
    private final Decorator decorator;

    public NumberCommand(int message) {
        this.message = message;
        this.decorator = new PrefixDecorator("primitive");
    }

    @Override
    public boolean isSame(Command command) {
        return getClass().equals(command.getClass());
    }

    @Override
    public String toString() {
        return this.decorator.decorate(String.valueOf(this.message));
    }
}
