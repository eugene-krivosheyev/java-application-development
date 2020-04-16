package com.acme.dbo.txlog;

interface Command {

    Command accumulate(Controller controller, Command command);
}
