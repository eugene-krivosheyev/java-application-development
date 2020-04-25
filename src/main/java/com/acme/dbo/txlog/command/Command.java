package com.acme.dbo.txlog.command;

import com.acme.dbo.txlog.Controller;

import java.io.IOException;

public interface Command {

    String getDecoratedState(int duplicationNum);

    Command accumulate(Controller controller, Command command) throws IOException;

    String getCurrentValue();

    void flush() throws IOException;

}
