package com.acme.dbo.txlog;

import com.sun.org.apache.xml.internal.security.c14n.implementations.Canonicalizer11_OmitComments;

import java.util.Objects;

public class CommandString implements Command {
    private final String message;

    public CommandString(String message) {
        this.message = message;
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


        return new CommandString(this.message + ((CommandString) currentState).getMessage());

        //  else return currentState;

    }

    @Override
    public String decorate(Command command) {
        return this.message.toString();
    }
}
