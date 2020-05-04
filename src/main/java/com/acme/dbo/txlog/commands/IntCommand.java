package com.acme.dbo.txlog.commands;

public class IntCommand extends NumCommand<Integer> {

    public IntCommand(Integer message) {
        super(message);
    }

    @Override
    public boolean isSame(Command command) {
        return command instanceof IntCommand;
    }

    @Override
    public boolean validate(Command command) {
        return ! isOverflow(message, ((IntCommand)command).getMessage(), Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    @Override
    public void accumulate(Command command) {
        message += ((IntCommand)command).getMessage();
    }

}
