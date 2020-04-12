package com.acme.dbo.txlog;

public class CommandByte implements Command {
    private Byte message;
    private static final String PREFIX_PRIMITIVE = "primitive: ";

    public CommandByte(Byte message) {
        this.message = message;
    }

    @Override
    public Boolean isSame(Command currentState) {
        return currentState instanceof CommandByte;
    }

    @Override
    public Command updateState(Command currentState) {
        Byte currentStateMessage = ((CommandByte) currentState).getMessage();
        if (checkNotOverMaxByte(this.message, currentStateMessage))
            return new CommandInt(this.message + currentStateMessage);
        else return null;

    }

    private Byte getMessage() {
        return message;
    }

    private static boolean checkNotOverMaxByte(byte a, byte b) {
        return (a >= 0 && (byte) (a + b) >= b || a < 0 && (byte) (a + b) < b);
    }

    @Override
    public String decorate(Command command) {
        return PREFIX_PRIMITIVE + this.message.toString();
    }
}
