package com.acme.dbo.txlog;

import java.util.Objects;

public class CommandInt implements Command {
    private Integer message;
    private static final String PREFIX_PRIMITIVE = "primitive: ";

    public CommandInt(Integer message) {
        this.message = message;
    }

    public Integer getMessage() {
        return message;
    }

    @Override
    public Boolean isSame(Command currentState) {
        return currentState instanceof CommandInt;
    }

    @Override
    public Command updateState(Command currentState) {

        Integer currentStateMessage = ((CommandInt) currentState).getMessage();
        if (checkNotOverMaxInt(this.message, currentStateMessage))
            return new CommandInt(this.message + currentStateMessage);
        else return null;

        // else return currentState;
    }

    private static boolean checkNotOverMaxInt(int a, int b) {
        return (a >= 0 && a + b >= b || a < 0 && a + b < b);
    }

    @Override
    public String decorate(Command command) {
        return PREFIX_PRIMITIVE + this.message.toString();
    }
}
