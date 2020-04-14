package com.acme.dbo.txlog;

import com.acme.dbo.command.ByteCommand;
import com.acme.dbo.command.IntCommand;
import com.acme.dbo.command.NullCommand;
import com.acme.dbo.command.StringCommand;
import com.acme.dbo.writer.ConsoleLogWriter;
import com.acme.dbo.controller.LoggerController;

public class Facade {

    public static final String PRIMITIVE = "primitive: ";
    public static final String STRING = "string: ";


    public static final byte TYPENOTDEFINED = 0;
    public static final byte TYPEBYTE = 1;
    public static final byte TYPEINT = 2;
    public static final byte TYPESTRING = 4;

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
