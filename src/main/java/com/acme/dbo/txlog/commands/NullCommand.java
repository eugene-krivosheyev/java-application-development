package com.acme.dbo.txlog.commands;

import com.acme.dbo.txlog.commands.Command;

import javax.naming.OperationNotSupportedException;

public class NullCommand implements Command {
    @Override
    public Command accumulate(Command command) throws Exception {
        throw new OperationNotSupportedException();
    }
}
