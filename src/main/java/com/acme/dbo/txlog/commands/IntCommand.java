package com.acme.dbo.txlog.commands;

import com.acme.dbo.txlog.Command;

public class IntCommand implements Command {

    private int state;

    public IntCommand(int state) {
        this.state = state;
    }

    public int getState() {
        return state;
    }

    @Override
    public boolean canBeBuffered(Command command) {
        if (!this.equals(command)) return false;

        int inState = ((IntCommand) command).getState();
        return (inState <= Integer.MAX_VALUE - state);
    }

    @Override
    public IntCommand accumulate(Command command) {
        int inState = ((IntCommand) command).getState();
        return new IntCommand(inState + state);
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
        return obj instanceof IntCommand;
    }
}
