package com.acme.dbo.txlog.commands;

public abstract class NumCommand<T extends Number> implements Command {
    protected T message;

    public NumCommand(T message) {
        this.message = message;
    }

    @Override
    public String getDecoratedMessage() {
        return "primitive: " + getMessage();
    }

    @Override
    public abstract boolean isSame(Command command);

    @Override
    public abstract boolean validate(Command command);

    @Override
    public abstract void accumulate(Command command);

    protected T getMessage() {
        return message;
    }
    
    protected boolean isNotOverflow(int a, int b, int max, int min) {
        return ((a <= 0 || b <= max - a) && (a >= 0 || b >= min - a));
    }

}
