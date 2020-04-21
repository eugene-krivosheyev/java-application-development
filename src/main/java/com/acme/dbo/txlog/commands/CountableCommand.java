package com.acme.dbo.txlog.commands;

import com.acme.dbo.txlog.decorators.Decorator;

abstract public class CountableCommand extends AbstractCommand {
    private int count;
    protected Decorator decorator;
    protected Object message;

    public CountableCommand() {
        this.count = 1;
    }

    @Override
    protected Command doAccumulation(Command command) {
        this.count++;
        return this;
    }

    @Override
    public void doAccumulationCheck(Command command) throws Exception {
        super.doAccumulationCheck(command);
        if(!message.equals(((CountableCommand) command).message)) {
            throw new Exception("Commands are not equals");
        }
    }

    @Override
    public String toString() {
        return this.decorator.decorate(String.valueOf(this.message), this.count);
    }
}
