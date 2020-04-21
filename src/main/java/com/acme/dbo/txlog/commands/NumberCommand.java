package com.acme.dbo.txlog.commands;

import com.acme.dbo.txlog.decorators.Decorator;

abstract public class NumberCommand extends AbstractCommand {
    protected final int message;
    protected final Decorator decorator;

    public NumberCommand(int message, Decorator decorator) {
        this.message = message;
        this.decorator = decorator;
    }

    @Override
    public String toString() {
        return this.decorator.decorate(String.valueOf(this.message));
    }

    protected long getLongSum(Command command) {
        return (long) message + ((NumberCommand) command).message;
    }
}
