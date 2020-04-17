package com.acme.dbo.txlog.command;


public class NullCommand extends CheckingCommand {
    private String message;

    public NullCommand()    {
        this.message = "";
    }

    @Override
    public void accumulateCommand(Command command) {
    }

    public boolean checkIsSame(Command command) {
        return true;
    }
}
