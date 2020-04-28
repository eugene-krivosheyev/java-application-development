package com.acme.dbo.txlog.commands;

import com.acme.dbo.txlog.exceptions.AccumulateException;

public interface Command {
    Command accumulate(Command command) throws AccumulateException;
}
