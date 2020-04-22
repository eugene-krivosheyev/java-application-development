package com.acme.dbo.txlog;

import com.acme.dbo.txlog.commands.*;
import com.acme.dbo.txlog.controllers.LoggerTypedController;
import com.acme.dbo.txlog.writers.ConsoleWriter;

public class Facade {
    static private LoggerTypedController controller = new LoggerTypedController(new ConsoleWriter());

    public static void flush() {
        controller.log(BaseCommand.EMPTY_COMMAND);
    }

    public static void log(int message) {
        controller.log(new IntCommand(message));
    }

    public static void log(byte message) {
        controller.log(new ByteCommand(message));
    }

    public static void log(String message) {
        try {
            controller.log(new StringCommand(message));
        } catch (CommandException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void log(Object message) {
        controller.log(new ObjectCommand(message));
    }

    public static void log(boolean message) {
        controller.log(new BooleanCommand(message));
    }

    public static void log(char message) {
        controller.log(new CharCommand(message));
    }
}