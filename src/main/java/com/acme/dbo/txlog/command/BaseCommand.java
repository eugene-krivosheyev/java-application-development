package com.acme.dbo.txlog.command;

import com.acme.dbo.txlog.Controller;

public abstract class BaseCommand implements Command {

    @Override
    public abstract Command accumulate(Controller controller, Command command);

    @Override
    public abstract String getCurrentValue();

    @Override
    public abstract String getDecoratedState(int duplicationNum);

    @Override
    public abstract void flush();

}
