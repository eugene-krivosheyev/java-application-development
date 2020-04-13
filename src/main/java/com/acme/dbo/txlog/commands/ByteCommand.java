package com.acme.dbo.txlog.commands;

public class ByteCommand implements Command {
    public static final String BYTE_DECORATION = "primitive: ";
    private byte message;

    public ByteCommand(byte message) {
        this.message = message;
    }

    public String getMessage() {
        return String.valueOf(message);
    }
    public String getDecoratedMessage() {
        return BYTE_DECORATION + getMessage();
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

    private boolean checkOverflow(int sum, int a, int b) {
        return (a > 0 && sum > b || a < 0 && sum < b);
    }
}
