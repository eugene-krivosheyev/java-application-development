package com.acme.dbo.txlog;

import com.acme.dbo.txlog.command.*;

import java.io.IOException;

public class Facade {
    private static Controller controller = new Controller(new ConsoleLogWriter());


    public static void log(int message) throws IOException {
        controller.log(new IntCommand(message));
    }

    public static void log(byte message) throws IOException {
        controller.log(new ByteCommand(message));
    }

    public static void log(String message) throws IOException {
        controller.log(new StringCommand(message));
    }

    public static void log(boolean message) throws IOException {
        controller.log(new BooleanCommand(message));
    }

    public static void log(char message) throws IOException {
        controller.log(new CharCommand(message));
    }

    public static void log(Object message) throws IOException {
        controller.log(new ObjectCommand(message));
    }

    public static void flush() throws IOException {
        controller.flush();
    }

}
