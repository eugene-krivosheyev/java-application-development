package com.acme.dbo.txlog.commands;

import com.acme.dbo.txlog.decorators.Decorator;
import com.acme.dbo.txlog.exceptions.AccumulateException;

public class IntCommand extends NumberCommand {
    public IntCommand(int message, Decorator decorator) {
        this.message = message;
        this.decorator = decorator;
    }

    protected void doAccumulationCheck(Command command) throws AccumulateException {
        super.doAccumulationCheck(command);
        if (getLongSum(command) > Integer.MAX_VALUE) {
            throw new AccumulateException("Overflow");
        }
    }

    protected Command doAccumulation(Command command) {
        return new IntCommand((int) getLongSum(command), decorator);
    }
}
