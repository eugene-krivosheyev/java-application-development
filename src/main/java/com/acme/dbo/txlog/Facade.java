package com.acme.dbo.txlog;

public class Facade {
    private static final LoggerController controller = new LoggerController(WriterFactory.create());

    public static void log(int i) {
        controller.log(new IntCommand(i));
    }

    public static void log(byte b) {
        controller.log(new ByteCommand(b));
    }

    public static void log(boolean b) {
        controller.log(new BooleanCommand(b));
    }

    public static void log(char c) {
        controller.log(new CharCommand(c));
    }

    public static void log(String s) {
        controller.log(new StringCommand(s));
    }

    public static void log(Object o) {
        controller.log(new ReferenceCommand(o));
    }

    public static void flush() {
        controller.flush();
    }
}
