package com.acme.dbo.txlog;

import java.sql.DriverManager;
import java.util.function.Function;

/**
 *
 */
public class Facade {
    public static int counter = 0; //global state -> behavior

    //JDBC
    //System
    static {
        System.out.println("hello!");
        //....
        //....
//        DriverManager.registerDriver(new Facade());
    }

    static {
        System.out.println("2");
    }


    /** Contract:
     * logs <b>ogogoggo!</b> message
     * @param message must be positive
     * @throws Exception
     * @see
     * @since 1.0
     */
//    @Contract(!null -> null, pure)
    public static void log(/* @NonNull */ int message) throws IllegalArgumentException {
        //assumeThatParamIsPosistive(message);

        int localVar = 0; //local, auto, stack, temp

        if (message <= 0) throw new IllegalArgumentException();
        //~~implementation comment~~
        final String decoratedMessage = "primitive: " + message;
        printToConsole(decoratedMessage);
    }

    /*
    multi-line
     */
    public static byte log(byte message) { //formal par
        int localVar = 1;
        System.out.println(localVar);
        printToConsole("primitive: " + message);

        message = 2;
        return 1;
    }

    public static void log(Object message) {}

    public static String log(String message) {
        return "s" + "d";
    }

    private static void printToConsole(String decoratedMessage) {
        System.out.println(decoratedMessage);
    }
}
