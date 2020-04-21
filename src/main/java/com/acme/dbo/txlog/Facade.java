package com.acme.dbo.txlog;

import com.acme.dbo.txlog.commands.*;
import com.acme.dbo.txlog.controllers.LoggerController;
import com.acme.dbo.txlog.decorators.PrefixDecorator;
import com.acme.dbo.txlog.writers.WriterFactory;

public class Facade {
    private static final LoggerController controller = new LoggerController(WriterFactory.create());

    public static void log(int i) {
        controller.log(new IntCommand(i, new PrefixDecorator("primitive")));
    }

    public static void log(byte b) {
        controller.log(new ByteCommand(b, new PrefixDecorator("primitive")));
    }

    public static void log(boolean b) {
        controller.log(new BooleanCommand(b, new PrefixDecorator("primitive")));
    }

    public static void log(char c) {
        controller.log(new CharCommand(c, new PrefixDecorator("char")));
    }

    public static void log(String s) {
        controller.log(new StringCommand(s, new PrefixDecorator("string")));
    }

    public static void log(Object o) {
        controller.log(new ReferenceCommand(o, new PrefixDecorator("reference")));
    }

    public static void flush() {
        controller.flush();
    }
}
