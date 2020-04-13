package com.acme.dbo.txlog.commands;

public interface Command {
    String getMessage();
    String getDecoratedMessage();
    boolean shouldAppend(Command state);
    Command append(Command state);
}
