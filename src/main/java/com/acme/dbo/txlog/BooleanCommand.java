package com.acme.dbo.txlog;

public class BooleanCommand extends RepeatableCommand {
    public BooleanCommand(boolean message) {
        super();
        this.message = message;
        this.decorator = new PrefixDecorator("primitive");
    }

    @Override
    public boolean isSame(Command command) {
        if(getClass().equals(command.getClass())) {
            return message == ((BooleanCommand) command).message;
        }
        return false;
    }
}
