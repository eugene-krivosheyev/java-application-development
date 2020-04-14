package com.acme.dbo.txlog.commands;

public interface Command {

    public String getDecoratedMessage();

    public boolean isSame(Command command);

    public boolean validate(Command command);

    public void accumulate(Command command);

}
