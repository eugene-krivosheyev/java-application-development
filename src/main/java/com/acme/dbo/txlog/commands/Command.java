package com.acme.dbo.txlog.commands;

public interface Command {
    String getDecoratedMessage();
    boolean isSame(Command command);
    boolean validate(Command command);
    void accumulate(Command command);
}
