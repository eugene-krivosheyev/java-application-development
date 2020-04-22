package com.acme.dbo.txlog.commands;

public interface Command {
    String getMessage();
    String getDecoratedMessage();
    /**
     * ShouldAppend checks overflow and condition for accumulation
    */
    boolean shouldAppend(Command state);
    Command append(Command state);
}
