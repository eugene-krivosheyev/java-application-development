package com.acme.dbo.txlog.commands;

public class IntCommand implements Command {
    public static final String INT_DECORATION = "primitive: ";
    private int message;

    public IntCommand(int message) {
        this.message = message;
    }

    public String getMessage() {
        return String.valueOf(message);
    }

    public String getDecoratedMessage() {
        return INT_DECORATION + getMessage();
    }

    public Command append(Command commandState) {
        if(commandState instanceof IntCommand){
            IntCommand intCommand = (IntCommand) commandState;
            if (checkOverflow(message + intCommand.message, message, intCommand.message)) {
                return new IntCommand(message + intCommand.message);
            }
        }
        return null;
    }

    private boolean checkOverflow(int sum, int a, int b) {
        return (a > 0 && sum > b || a < 0 && sum < b);
    }

}
