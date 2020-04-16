package com.acme.dbo.txlog;

interface Command {

    String getDecoratedState(int duplicationNum);

    Command accumulate(Controller controller, Command command);

    String getCurrentValue();

    void flush();

}
