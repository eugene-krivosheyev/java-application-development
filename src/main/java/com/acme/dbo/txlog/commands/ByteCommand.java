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
    public Command append(Command commandState) {
        if(commandState instanceof ByteCommand){
            ByteCommand byteCommand = (ByteCommand) commandState;
            if (checkOverflow((byte) (message + byteCommand.message), message, byteCommand.message)) {
                return new ByteCommand((byte) (message + byteCommand.message));
            }
        }
        return null;
    }

    private boolean checkOverflow(int sum, int a, int b) {
        return (a > 0 && sum > b || a < 0 && sum < b);
    }
}
