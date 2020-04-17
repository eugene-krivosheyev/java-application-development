package com.acme.dbo.txlog.command;

import static com.acme.dbo.txlog.Facade.PRIMITIVE;

public class IntCommand extends CheckingCommand {
    private int message;

    public IntCommand(int message)    {
        this.message = message;
    }

    public int getMessage() {
        return this.message;
    }

    @Override
    public void accumulateCommand(Command command) {
        this.message += ((IntCommand)command).getMessage();
    }

    public boolean checkNoOverflow(Command command) {
        int commandMessage = ((IntCommand)command).getMessage();
        if ((this.message > 0 && commandMessage > 0) || (this.message < 0 && commandMessage < 0)) {
            return (Integer.MAX_VALUE - Math.abs(this.message) >= Math.abs(commandMessage));
        } else {
            return true;
        }
    }

    public String getPrefix() {
        return PRIMITIVE;
    }

    public String getStringMessage () {
        return Integer.toString(this.message);
    }
}
