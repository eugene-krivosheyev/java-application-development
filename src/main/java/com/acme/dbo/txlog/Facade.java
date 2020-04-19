package com.acme.dbo.txlog;

import com.acme.dbo.txlog.command.*;

public class Facade {
    private static Controller controller = new Controller(new Writer());


    public static void log(int message) {
        controller.log(new IntCommand(message));
    }

    public static void log(byte message) {
        controller.log(new ByteCommand(message));
    }

    public static void log(String message) {
        controller.log(new StringCommand(message));
    }

    public static void log(boolean message) {
        controller.log(new BooleanCommand(message));
    }

    public static void log(char message) {
        controller.log(new CharCommand(message));
    }

    public static void log(Object message) {
        controller.log(new ObjectCommand(message));
    }

    public static void flush() {
        controller.flush();
    }

}
