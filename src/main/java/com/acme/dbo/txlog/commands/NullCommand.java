package com.acme.dbo.txlog.commands;

import com.acme.dbo.txlog.exceptions.AccumulateException;

public class NullCommand implements Command {
    @Override
    public Command accumulate(Command command) throws AccumulateException {
        throw new AccumulateException();
    }
}
