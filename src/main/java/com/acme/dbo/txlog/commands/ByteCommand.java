package com.acme.dbo.txlog.commands;

import static com.acme.dbo.txlog.commands.CommandUtils.checkOverflow;

public class ByteCommand extends BaseCommand {
    public static final String BYTE_DECORATION = "primitive: ";
    private byte message;

    public ByteCommand(byte message) {
        this.message = message;
    }
    protected String getDecorator(){
        return BYTE_DECORATION;
    }
    public String getMessage() {
        return String.valueOf(message);
    }


    @Override
    public boolean shouldAppend(Command state) {
        if(state instanceof ByteCommand){
            ByteCommand byteCommand = (ByteCommand) state;
            return checkOverflow((byte) (message + byteCommand.message), message, byteCommand.message);
        }
        return false;
    }

    public Command append(Command state) {
        return new ByteCommand((byte) (message + ((ByteCommand) state).message));
    }

}
