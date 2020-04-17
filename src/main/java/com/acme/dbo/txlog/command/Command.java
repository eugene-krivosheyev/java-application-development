package com.acme.dbo.txlog.command;

public interface Command {
    String decoratedMessage();
    void accumulateCommand(Command command);
    boolean isSame (Command command);
    boolean checkNoOverflow(Command command);
}