package com.acme.dbo.txlog;

public class ByteCommand {
    private byte message;

    public ByteCommand(byte message) {
        this.message = message;
    }

    public String getMessage() { return String.valueOf(message); }
    public String getDecoratedMessage() { return "primitive: " + getMessage();}
    public ByteCommand process(ByteCommand prevCommand) {
        if (prevCommand != null && !checkOverflow((byte) (message + prevCommand.message), message, prevCommand.message)) {
            return null;
        } if (prevCommand != null) {
            return new ByteCommand((byte) (message + prevCommand.message));
        } else {
            return this;
        }
    }

    private boolean checkOverflow(int sum, int a, int b) {
        return (a > 0 && sum > b || a < 0 && sum < b);
    }
}
