package com.acme.dbo.txlog.commands;

import com.acme.dbo.txlog.decorators.Decorator;

public class ByteCommand extends NumberCommand {
    public ByteCommand(byte message, Decorator decorator) {
        super(message, decorator);
    }

    protected void doAccumulationCheck(Command command) throws Exception {
        super.doAccumulationCheck(command);
        if (getLongSum(command) > Byte.MAX_VALUE) {
            throw new Exception("Overflow");
        }
    }

    protected Command doAccumulation(Command command) {
        return new ByteCommand((byte) getLongSum(command), decorator);
    }
}
