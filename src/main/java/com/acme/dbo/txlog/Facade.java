package com.acme.dbo.txlog;

//import java.io.IOException;

public class Facade {

    public static final String PRIMITIVE_PREFIX = "primitive: ";

    //region log methods
    public static void log(int message) {
        if (message >= 0)
            { printMessage(PRIMITIVE_PREFIX + message); }
        else
            throw new IllegalArgumentException("Message is less than 0.");
    }

    public static void log(byte message) {
        printMessage(PRIMITIVE_PREFIX + message);
    }

    public static void log(char message) {
        printMessage("char: " + message);
    }

    public static void log(String message) {
        printMessage("string: " + message);
    }

    public static void log(boolean message) {
        printMessage(PRIMITIVE_PREFIX + message);
    }

    public static void log(Object message) {
        printMessage("reference: " + message);
    }
    //endregion

    private static void printMessage(Object message) {

        System.out.println(message);
    }
}
