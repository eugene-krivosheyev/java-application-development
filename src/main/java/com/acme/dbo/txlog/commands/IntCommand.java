package com.acme.dbo.txlog.commands;

import com.acme.dbo.txlog.decorators.Decorator;

public class IntCommand extends NumberCommand {
    public IntCommand(int message, Decorator decorator) {
        super(message, decorator);
    }

    protected void doAccumulationCheck(Command command) throws Exception {
        super.doAccumulationCheck(command);
        if (getLongSum(command) > Integer.MAX_VALUE) {
            throw new Exception("Overflow");
        }
    }

    protected Command doAccumulation(Command command) {
        return new IntCommand((int) getLongSum(command), decorator);
    }
}
