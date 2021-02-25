package com.acme.dbo.txlog;

import javax.security.auth.*;

/**
 * Facade
 * @author kjghdkfjghdkfjhg
 * @since 1.0
 */

public class Facade {
    public static int переменнаяИзНескольктихСлов = 1; //static, global
    public static final int MY_CONST = 2;

    /**
     * message != null
     */
    //@Contract(!null -> !null)
    public static void log(/* @NotNull */ int message) {
        int i喝шш; //stack, auto, local

        if (message <= 0) throw new IllegalArgumentException();
        //--implementation как?--
        printToConsole(message);
        //...
    }

    public static void log(byte message) {
        printToConsole(message);
    }


    private static void printToConsole(int message) {
        System.out.println("primitive: " + message);
    }
}
// single-line
