package com.acme.dbo.txlog.commands;

import com.acme.dbo.txlog.decorators.Decorator;
import com.acme.dbo.txlog.exceptions.AccumulateException;

public class ByteCommand extends NumberCommand {
    public ByteCommand(byte message, Decorator decorator) {
        super(message, decorator);
    }

    protected void doAccumulationCheck(Command command) throws AccumulateException {
        super.doAccumulationCheck(command);
        if (getLongSum(command) > Byte.MAX_VALUE) {
            throw new AccumulateException("Overflow");
        }
    }

    protected Command doAccumulation(Command command) {
        return new ByteCommand((byte) getLongSum(command), decorator);
    }
}
