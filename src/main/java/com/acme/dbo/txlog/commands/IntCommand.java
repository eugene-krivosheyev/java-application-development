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

    private boolean checkOverflow(int sum, int a, int b) {
        return (a > 0 && sum > b || a < 0 && sum < b);
    }

}
