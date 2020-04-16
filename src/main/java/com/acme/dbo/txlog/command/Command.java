package com.acme.dbo.txlog.command;

import com.acme.dbo.txlog.Controller;

public interface Command {

    String getDecoratedState(int duplicationNum);

    Command accumulate(Controller controller, Command command);

    String getCurrentValue();

    void flush();

}
