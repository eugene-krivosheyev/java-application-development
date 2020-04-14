package com.acme.dbo.txlog;

public interface Command {
    boolean isSame(Command command);

    Command accumulate(Command command) throws Exception;
}
