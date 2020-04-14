package com.acme.dbo.command;

public interface Command {
    String decoratedMessage();
    Command accumulateCommand(Command command);
    boolean isSame (Command command);
    boolean checkOverflow(Command command);
}