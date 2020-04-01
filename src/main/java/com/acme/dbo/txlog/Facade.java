package com.acme.dbo.txlog;

public class Facade {
    static private LoggerTypeController controller = new LoggerTypeController();

    public static void flush() {
        controller.flush();
    }

    public static void log(int message) {
        controller.log(Primitives.INT, message);
    }


    public static void log(byte message) {
        controller.log(Primitives.BYTE, message);
    }


    public static void log(String message) {
        controller.log(Primitives.STRING,message);

    }

    public static void log(Object message) {
        controller.log(Primitives.OBJECT,message);
    }

    public static void log(boolean message) {
        controller.log(Primitives.BOOLEAN,message);

    }

    public static void log(char message) {
        controller.log(Primitives.CHAR,message);

    }

}