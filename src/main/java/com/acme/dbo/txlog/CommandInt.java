package com.acme.dbo.txlog;

import java.util.Objects;

public class CommandInt implements Command {
    private Integer message;

    public CommandInt(Integer message) {
        this.message = message;
    }

    public Integer getMessage() {
        return message;
    }

    @Override
    public Boolean isSame(Command currentState) {
        return currentState instanceof CommandInt;
    }

    @Override
    public Command updateState(Command currentState) {


        return new CommandInt(this.message + ((CommandInt) currentState).getMessage());

        // else return currentState;
    }

    @Override
    public String decorate(Command command) {
        return this.message.toString();
    }
}
