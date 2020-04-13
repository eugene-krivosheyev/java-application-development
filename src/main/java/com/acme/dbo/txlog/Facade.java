package com.acme.dbo.txlog;


public class Facade {
    static private Controller controller = new Controller(new LogWriter());


    public static void flush() {
        controller.flush();
    }

    public static void log(String message) {
        controller.log(new CommandString(message));
    }

    public static void log(int message) {
        controller.log(new CommandInt(message));
    }


    public static void log(byte message) {
        controller.log(new CommandByte(message));
    }


    public static void log(boolean message) {
        controller.log(new CommandBoolean(message));
    }

    public static void log(char message) {
        controller.log(new CommandChar(message));
    }

    public static void log(Object message) {
        controller.log(new CommandObject(message));
    }

}
