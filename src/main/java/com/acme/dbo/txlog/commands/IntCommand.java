package com.acme.dbo.txlog.commands;

import static com.acme.dbo.txlog.commands.CommandUtils.checkOverflow;

public class IntCommand extends BaseCommand {
    public static final String INT_DECORATION = "primitive: ";
    private int message;

    public IntCommand(int message) {
        this.message = message;
    }
    protected String getDecorator(){
        return INT_DECORATION;
    }

    public String getMessage() {
        return String.valueOf(message);
    }

    @Override
    public boolean shouldAppend(Command state) {
        if(state instanceof IntCommand){
            IntCommand intCommand = (IntCommand) state;
            return checkOverflow(message + intCommand.message, message, intCommand.message);
        }
        return false;
    }

    public Command append(Command state) {
        return new IntCommand(message + ((IntCommand) state).message);
    }
}
