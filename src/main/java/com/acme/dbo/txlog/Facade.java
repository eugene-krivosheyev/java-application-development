package com.acme.dbo.txlog;

//import java.io.IOException;

public class Facade {

    //region log methods
    public static void log(int message) {
        if (message >= 0)
            { printout(message); }
        else
            throw new IllegalArgumentException("Message is less than 0.");
    }

    public static void log(byte message) {
        printout(message);
    }

    public static void log(char message) {
        printout(message);
    }

    public static void log(String message) {
        printout(message);
    }

    public static void log(boolean message) {
        printout(message);
    }

    public static void log(Object message) {
        printout(message);
    }
    //endregion

    //region printout methods
    private static void printout(int message) {

        System.out.println("primitive: " + message);
    }

    private static void printout(char message) {

        System.out.println("char: " + message);
    }

    private static void printout(String message) {

        System.out.println("string: " + message);
    }

    private static void printout(boolean message) {

        System.out.println("primitive: " + message);
    }

    private static void printout(Object message) {

        System.out.println("reference: " + message);
    }
    //endregion
}
