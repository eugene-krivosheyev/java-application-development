package com.acme.dbo.txlog;

import com.acme.dbo.txlog.commands.*;

public class Facade {

    private static LogController controller = new LogController();

    public static void log(int message) {
        controller.write(new IntCommand(message));
    }

    public static void log(byte message) {
        controller.write(new ByteCommand(message));
    }

    public static void log(boolean message) {
        controller.write(new BooleanCommand(message));
    }

    public static void log(Object message) {
        controller.write(new ObjectCommand(message));
    }

    public static void log(char message) {
        controller.write(new CharCommand(message));
    }

    public static void log(String message) {
        controller.write(new StringCommand(message));
    }

    public static void setDecorated(boolean isDecorated) {
        controller.setDecorated(isDecorated);
    }

    public static void flush() {
        controller.flush();
    }
}