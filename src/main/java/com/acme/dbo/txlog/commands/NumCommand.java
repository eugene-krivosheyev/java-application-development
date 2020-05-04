package com.acme.dbo.txlog.commands;

public class NumCommand<T extends Number> implements Command {

    protected T message;

    public NumCommand(T message) {
        this.message = message;
    }

    @Override
    public String getDecoratedMessage() {
        return "primitive: " + getMessage();
    }

    @Override
    public boolean isSame(Command command) {
        return false;
    }

    @Override
    public boolean validate(Command command) {
        return false;
    }

    @Override
    public void accumulate(Command command) {

    }

    protected T getMessage() {
        return message;
    }
    
    protected boolean isOverflow(int a, int b, int max, int min) {
        return ((a > 0 && b > max - a) || (a < 0 && b < min - a));
    }

}
