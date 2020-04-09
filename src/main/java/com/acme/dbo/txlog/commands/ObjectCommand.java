package com.acme.dbo.txlog.commands;

import com.acme.dbo.txlog.Command;

public class ObjectCommand implements Command {

    private Object state;

    public ObjectCommand(Object state) {
        this.state = state;
    }

    @Override
    public Command accumulate(Command command) {
        return command;
    }

    @Override
    public boolean canBeBuffered(Command command) {
        return false;
    }

    @Override
    public String getDecoratePrefix() {
        return "reference";
    }

    @Override
    public String toString() {
        return state.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null){
            return false;
        }
        return obj instanceof ObjectCommand;
    }
}
