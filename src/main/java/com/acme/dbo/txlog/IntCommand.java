package com.acme.dbo.txlog;

public class IntCommand {
    private int message;

    public IntCommand(int message) {
        this.message = message;
    }

    public String getMessage() { return String.valueOf(message); }
    public String getDecoratedMessage() { return "primitive: " + getMessage();}
    public IntCommand process(IntCommand prevCommand) {
        if (prevCommand != null && !checkOverflow(message + prevCommand.message, message, prevCommand.message)) {
            return null;
        } else if (prevCommand != null) {
            return new IntCommand(message + prevCommand.message);
        } else {
            return this;
        }

    }

    private boolean checkOverflow(int sum, int a, int b) {
        return (a > 0 && sum > b || a < 0 && sum < b);
    }

}
