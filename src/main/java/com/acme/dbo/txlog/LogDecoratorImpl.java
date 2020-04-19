package com.acme.dbo.txlog;

public class LogDecoratorImpl implements LogDecorator {

    private boolean isDecorated;

    public LogDecoratorImpl() {
        isDecorated = Boolean.valueOf(System.getProperty("isDecorated", "false"));
    }

    @Override
    public String decorate(Command command) {
        if (command == null) {
            return "";
        }

        if (isDecorated) {
            return command.getDecoratePrefix() + ": " + command.toString();
        } else {
            return command.toString();
        }
    }

    @Override
    public void setDecorated(boolean decorated) {
        isDecorated = decorated;
    }

}
