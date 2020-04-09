package com.acme.dbo.txlog.commands;

import com.acme.dbo.txlog.Command;

public class ByteCommand implements Command {

    private byte state;

    public ByteCommand(byte state) {
        this.state = state;
    }

    public byte getState() {
        return state;
    }

    @Override
    public ByteCommand accumulate(Command command) {
        byte inState = ((ByteCommand) command).getState();
        return new ByteCommand((byte) (inState + state));
    }

    @Override
    public boolean canBeBuffered(Command command) {
        byte inState = ((ByteCommand) command).getState();
        return inState <= Byte.MAX_VALUE - state;
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
        return obj instanceof ByteCommand;
    }
}












