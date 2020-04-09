package com.acme.dbo.txlog.commands;

import com.acme.dbo.txlog.Command;

public class BooleanCommand implements Command {

    private boolean state;

    public BooleanCommand(boolean state) {
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
        return "primitive";
    }

    @Override
    public String toString() {
        return String.valueOf(state);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null){
            return false;
        }
        return obj instanceof BooleanCommand;
    }
}
