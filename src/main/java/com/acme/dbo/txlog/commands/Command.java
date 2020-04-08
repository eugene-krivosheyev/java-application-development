package com.acme.dbo.txlog.commands;

public interface Command {
   String getMessage();
    String getDecoratedMessage();
    Command append(Command commandState);
}
