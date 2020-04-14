package com.acme.dbo.command;

import static com.acme.dbo.txlog.Facade.PRIMITIVE;

public class IntCommand implements Command {
    private int message;

    public IntCommand(int message)    {
        this.message = message;
    }

    public int getMessage() {
        return this.message;
    }

    @Override
    public String decoratedMessage() {
        return (PRIMITIVE + Integer.toString(this.message));
    }

    @Override
    public Command accumulateCommand(Command command) {
        this.message += ((IntCommand)command).getMessage();
        return this;
    }

    public boolean isSame(Command command) {
        return command instanceof IntCommand;
    }

    public boolean checkOverflow(Command command) {
        int commandMessage = ((IntCommand)command).getMessage();
        if ((this.message > 0 && commandMessage > 0) || (this.message < 0 && commandMessage < 0)) {
            return (Integer.MAX_VALUE - Math.abs(this.message) >= Math.abs(commandMessage));
        } else {
            return true;
        }
    }
}
