package com.acme.dbo.txlog.commands;

import com.acme.dbo.txlog.exceptions.AccumulateException;

abstract public class CountableCommand extends AbstractCommand {
    private int count;

    public CountableCommand() {
        this.count = 1;
    }

    @Override
    protected Command doAccumulation(Command command) {
        this.count++;
        return this;
    }

    @Override
    public void doAccumulationCheck(Command command) throws AccumulateException {
        super.doAccumulationCheck(command);
        if(!message.equals(((CountableCommand) command).message)) {
            throw new AccumulateException("Commands are not equals");
        }
    }

    @Override
    public String toString() {
        return this.decorator.decorate(String.valueOf(this.message), this.count);
    }
}
