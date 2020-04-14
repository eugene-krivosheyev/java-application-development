package com.acme.dbo.txlog.commands;

public class IntCommand implements Command {

    private Integer message = 0;

    public IntCommand(int message) {
        this.message = message;
    }

    public int getMessage() {
        return message;
    }

    @Override
    public String getDecoratedMessage() {
        return "primitive: " + getMessage();
    }

    @Override
    public boolean isSame(Command command) {
        return command instanceof IntCommand;
    }

    @Override
    public boolean validate(Command command) {
        return ! isOverflow(message, ((IntCommand)command).getMessage());
    }

    @Override
    public void accumulate(Command command) {
        message += ((IntCommand)command).getMessage();
    }

    private boolean isOverflow(int a, int b) {
        return  ((a > 0 && b > Integer.MAX_VALUE - a) || (a < 0 && b < Integer.MIN_VALUE - a));
    }

}
