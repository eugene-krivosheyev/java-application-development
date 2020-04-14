package com.acme.dbo.txlog;

public interface Command {
    byte getMessageType ();
    String getMessage();
    String decoratedMessage();
    Command accumulateCommand(Command command);
    boolean isSame (Command command);
    boolean checkOverflow(Command command);
}