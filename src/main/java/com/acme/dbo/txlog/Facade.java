package com.acme.dbo.txlog;

import java.sql.DriverManager;
import java.util.function.Function;

/**
 *
 */
public class Facade {
    public static final String PRIMITIVE_PREFIX = "primitive: ";

    public static int counter = 0; //global state -> behavior

    /** Contract:
     * logs <b>ogogoggo!</b> message
     * @param message must be positive
     * @throws Exception
     * @see
     * @since 1.0
     */
    public static void log(int message) throws IllegalArgumentException {
        print(message);
    }

    /*
    multi-line
     */
    public static void log(byte message) { //formal par
        print(message);
    }

    private static void print(int message) {
        System.out.println(PRIMITIVE_PREFIX + message);
    }
}
