package com.acme.dbo.txlog;

//import java.io.IOException;

public class Facade {

    public static void log(int message) {
        if (message >= 0)
            { printout(message); }
        else
            throw new IllegalArgumentException("Message is less than 0.");
    }

    public static void log(byte message) {
        printout(message);
    }

    private static void printout(int message) {
        System.out.println("primitive: " + message);
    }
}
