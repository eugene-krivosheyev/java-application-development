package com.acme.dbo.txlog.commands;

public abstract class AbstractCommand implements Command {
    @Override
    public Command accumulate(Command command) throws Exception {
        doAccumulationCheck(command);
        return doAccumulation(command);
    }

    protected void doAccumulationCheck(Command command) throws Exception {
        Class<? extends Command> thisClass = getClass();
        Class<? extends Command> argumentClass = command.getClass();
        if (!thisClass.equals(argumentClass)) {
            throw new Exception(String.format("%s can't accumulate %s", thisClass, argumentClass));
        }
    }

    protected abstract Command doAccumulation(Command command);
}
