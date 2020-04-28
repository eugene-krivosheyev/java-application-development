package com.acme.dbo.txlog.commands;

abstract public class NumberCommand extends AbstractCommand {
    protected Number message;

    @Override
    public String toString() {
        return this.decorator.decorate(String.valueOf(this.message));
    }

    protected long getLongSum(Command command) {
        return message.longValue() + ((NumberCommand) command).message.longValue();
    }
}
