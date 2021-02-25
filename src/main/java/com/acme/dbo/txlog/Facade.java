package com.acme.dbo.txlog;

/**
 * Facade
 * @author kjghdkfjghdkfjhg
 * @since 1.0
 */
public class Facade {
    /**
     * message != null
     */
    //@Contract(!null -> !null)
    public static void log(/* @NotNull */ int message) {
        if (message <= 0) throw new IllegalArgumentException();
        //--implementation как?--
        printToConsole(message);
    }

    public static void log(byte message) {
        printToConsole(message);
    }


    private static void printToConsole(int message) {
        System.out.println("primitive: " + message);
    }
}
// single-line
