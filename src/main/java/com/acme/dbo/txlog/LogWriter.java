package com.acme.dbo.txlog;

public class LogWriter {

    private boolean isDecorated;


    public void write(Command command) {
        System.out.println(decorate(command));
    }

    private String decorate(Command command) {
        if (command == null){
            return "";
        }

        if (isDecorated) {
            return command.getDecoratePrefix() + ": " + command.toString();
        } else {
            return command.toString();
        }
    }

    public void setDecorated(boolean decorated) {
        isDecorated = decorated;
    }
}
