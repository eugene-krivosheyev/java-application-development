package com.acme.dbo.txlog;


public interface Command {

    Command accumulate(Command command);

    boolean canBeBuffered(Command command);

    String getDecoratePrefix();
}
