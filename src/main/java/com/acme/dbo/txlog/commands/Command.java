package com.acme.dbo.txlog.commands;

public interface Command {
    Command accumulate(Command command) throws Exception;
}
