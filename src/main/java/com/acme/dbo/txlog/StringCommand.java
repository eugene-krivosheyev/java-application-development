package com.acme.dbo.txlog;

import java.util.Objects;

public class StringCommand extends TemplateCommand {
    private String message;
    private int stringCount;

    public StringCommand(String message) {
        this.message = message;
    }

    private StringCommand(String message, int stringCount) {
        this.message = message;
        this.stringCount = stringCount;
    }

    @Override
    public boolean isDataOverloaded(Command command) {
        if (isSame(command)) {
            return !Objects.equals(((StringCommand) command).message, this.message);
        }
        return true;
    }

    @Override
    public Command accumulate(Command command) {
        if (isSame(command)) {
            return updateState((StringCommand) command);
        } else return new StringCommand(message);
    }

    @Override
    public String toString() {
        if (stringCount == 0) {
            return "string: " + message;
        } else {
            return "string: " + message + " (x" + (stringCount + 1) + ")";
        }
    }

    @Override
    public boolean isNotAccumulatable() {
        return false;
    }

    private StringCommand updateState(StringCommand command) {
        if (Objects.nonNull(command) && Objects.equals(command.message, this.message)) {
            return new StringCommand(message, command.stringCount + 1);
        } else {
            return new StringCommand(message);
        }
    }
}
