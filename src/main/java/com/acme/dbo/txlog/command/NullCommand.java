package com.acme.dbo.txlog.command;

import com.acme.dbo.txlog.Controller;

public class NullCommand implements Command {
    public NullCommand(String anyMessage) {
    }

    @Override
    public String getDecoratedState(int duplicationNum) {
        return null;
    }

    @Override
    public NullCommand accumulate(Controller controller, Command command) {
        return this;
    }

    @Override
    public String getCurrentValue() {
        return "";
    }

    @Override
    public void flush() {

    }
}
