package com.acme.dbo.txlog;

import static java.lang.System.*;

public class Facade {
    public static void log(int message) {

        printIntToConsole(message);
    }

    public static void log(byte message) {

        printIntToConsole(message);
    }

    private static void printIntToConsole(int message) {

        out.println("primitive: " + message);

    }
}
