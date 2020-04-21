package com.acme.dbo.txlog.command;

import com.acme.dbo.txlog.Controller;

public class BaseCommand implements Command {

    @Override
    public Command accumulate(Controller controller, Command command) {
        return this;
    }

    @Override
    public String getCurrentValue() {
        String o = null;
        return o;
    }

    @Override
    public String getDecoratedState(int duplicationNum) {
        return null;
    }

    @Override
    public void flush() {
    }

}
