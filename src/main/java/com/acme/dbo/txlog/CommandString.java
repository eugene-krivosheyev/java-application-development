package com.acme.dbo.txlog;

import com.sun.org.apache.xml.internal.security.c14n.implementations.Canonicalizer11_OmitComments;

import java.util.Objects;

public class CommandString implements Command {
    private final String message;
    private static final String PREFIX_STRING = "string: ";
    private int stringCounter;

    public CommandString(String message) {
        this.message = message;
        this.stringCounter = 1;
    }

    public CommandString(String message, int stringCounter) {
        this.message = message;
        this.stringCounter = stringCounter;
    }

    @Override
    public Boolean isSame(Command currentState) {
        return currentState instanceof CommandString;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public Command updateState(Command currentState) {

        if (this.message.equals(((CommandString) currentState).getMessage())) {
            //  stringCounter++;
            return new CommandString(this.message, ((CommandString) currentState).stringCounter++);
        } else return null;

        //  else return currentState;

    }

    @Override
    public String decorate(Command command) {
        String message = this.message.toString() + (stringCounter > 1 ? (" (x" + stringCounter + ")") : "");
        stringCounter = 1;
        return PREFIX_STRING + message;

    }
}
