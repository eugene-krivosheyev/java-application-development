package com.acme.dbo.txlog;

import java.util.Objects;

public class IntCommand extends TemplateCommand {

    private int message;

    public IntCommand(int message) {
        this.message = message;
    }

    @Override
    public boolean isDataOverloaded(Command command) {
        if (isSame(command)) {
            try {
                int addExact = Math.addExact(message, ((IntCommand) command).message);
                return false;
            } catch (ArithmeticException e) {
                return true;
            }
        }
        return true;
    }

    @Override
    public IntCommand accumulate(Command command) {
        int intAccum = message;
        if (isSame(command)) {
            try {
                intAccum = Math.addExact(message, ((IntCommand) command).message);
            } catch (ArithmeticException ignored) {
            }
        }
        return new IntCommand(intAccum);
    }

    @Override
    public String toString() {
        return "primitive: " + message;
    }

    @Override
    public boolean isNotAccumulatable() {
        return false;
    }
}
