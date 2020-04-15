package com.acme.dbo.txlog;

public class CharCommand extends TemplateCommand {

    private char message;

    public CharCommand(char message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "char: " + message;
    }
}
