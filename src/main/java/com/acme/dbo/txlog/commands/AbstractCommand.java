package com.acme.dbo.txlog.commands;

import com.acme.dbo.txlog.decorators.Decorator;
import com.acme.dbo.txlog.exceptions.AccumulateException;

public abstract class AbstractCommand implements Command {
    protected Decorator decorator;
    protected Object message;

    @Override
    public Command accumulate(Command command) throws AccumulateException {
        doAccumulationCheck(command);
        return doAccumulation(command);
    }

    protected void doAccumulationCheck(Command command) throws AccumulateException {
        Class<? extends Command> thisClass = getClass();
        Class<? extends Command> argumentClass = command.getClass();
        if (!thisClass.equals(argumentClass)) {
            throw new AccumulateException(String.format("%s can't accumulate %s", thisClass, argumentClass));
        }
    }

    protected abstract Command doAccumulation(Command command);
}
