package com.acme.dbo.txlog;

public interface Command {
    boolean isSame(Command command);
    boolean isDataOverloaded(Command command);
    Command accumulate(Command command);
    boolean isNotAccumulatable();
}
