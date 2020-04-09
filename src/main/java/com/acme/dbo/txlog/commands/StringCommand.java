package com.acme.dbo.txlog.commands;

import com.acme.dbo.txlog.Command;

public class StringCommand implements Command {

    private int sameLinesCount;
    private String state;

    public StringCommand(String state, int sameLinesCount) {
        this.sameLinesCount = sameLinesCount;
        this.state = state;
    }

    public StringCommand(String state) {
        this.state = state;
    }

    @Override
    public Command accumulate(Command command) {
        int inCount = ((StringCommand) command).getSameLinesCount();
        int increment = inCount != 0 ? inCount : 1;
        return new StringCommand(state, sameLinesCount + increment);
    }

    @Override
    public boolean canBeBuffered(Command command) {
        StringCommand inCommand = (StringCommand) command;
        return state.equals(inCommand.getState());
    }

    @Override
    public String getDecoratePrefix() {
        return "string";
    }

    public String getState() {
        return state;
    }

    public int getSameLinesCount() {
        return sameLinesCount;
    }

    @Override
    public String toString() {
        if (sameLinesCount > 0) {
            return (String.format("%s (x%d)", state, ++sameLinesCount));
        } else {
            return state;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null){
            return false;
        }
        return obj instanceof StringCommand;
    }
}