package com.acme.dbo.txlog;

import com.acme.dbo.txlog.command.ByteCommand;
import com.acme.dbo.txlog.command.IntCommand;
import com.acme.dbo.txlog.command.NullCommand;
import com.acme.dbo.txlog.command.StringCommand;
import com.acme.dbo.txlog.writer.ConsoleLogWriter;
import com.acme.dbo.txlog.controller.LoggerController;

public class Facade {

    public static final String PRIMITIVE = "primitive: ";
    public static final String STRING = "string: ";

    private static LoggerController controller = new LoggerController(new ConsoleLogWriter());

    public static void log(int message) {
        controller.log(new IntCommand(message));
    }

    public static void log(String message) {
        controller.log(new StringCommand(message));
    }

    public static void log(byte message) {
        controller.log(new ByteCommand(message));
    }

    public static void log() {
        controller.log(new NullCommand());
    }
}
