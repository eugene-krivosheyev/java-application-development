package com.acme.dbo.txlog;

public class ConsoleLogWriter implements LogWriter {

    private boolean isDecorated;


    @Override
    public void write(Command command) {
        System.out.println(decorate(command));
    }

    @Override
    public String decorate(Command command) {
        if (command == null){
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
