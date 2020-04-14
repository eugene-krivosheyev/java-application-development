package com.acme.dbo.txlog;

public class CharCommand extends RepeatableCommand {
    public CharCommand(char message) {
        super();
        this.message = message;
        this.decorator = new PrefixDecorator("char");
    }

    @Override
    public boolean isSame(Command command) {
        if(getClass().equals(command.getClass())) {
            return message == ((CharCommand) command).message;
        }
        return false;
    }
}
