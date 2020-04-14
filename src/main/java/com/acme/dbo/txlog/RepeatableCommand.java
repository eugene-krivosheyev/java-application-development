package com.acme.dbo.txlog;

abstract public class RepeatableCommand implements Command {
    private int repetitions;
    protected Decorator decorator;
    protected Object message;

    public RepeatableCommand() {
        this.repetitions = 1;
    }

    @Override
    public Command accumulate(Command command) {
        this.repetitions++;
        return this;
    }

    @Override
    public boolean isSame(Command command) {
        if (getClass().equals(command.getClass())) {
            return message.equals(((RepeatableCommand) command).message);
        }
        return false;
    }

    @Override
    public String toString() {
        return this.decorator.decorate(String.valueOf(this.message), this.repetitions);
    }
}
