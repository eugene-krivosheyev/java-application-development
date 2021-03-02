/**
 * jkgjdhkgjhdfkgjdhfk
 */
package com.acme.dbo.txlog;

import javax.security.auth.*;
import java.util.stream.IntStream;

/**
 * Facade
 * @author kjghdkfjghdkfjhg
 * @since 1.0
 */

public class Facade {
    public static int переменнаяИзНескольктихСлов; //static, global
    public static final int MY_CONST = 2;

    static {
        System.out.println("static block");
//        new IntStream("file"); // -> exception?
        //....
    }

    static {
        System.out.println("vvv");
        //....
    }

    /**
     * message != null
     */
    //@Contract(!null -> !null)
    public static void log(/* @NotNull */ int message) { //formal arg
        int i喝шш = 1; //stack, auto, local
        System.out.println(i喝шш);

        System.out.println(переменнаяИзНескольктихСлов);
        if (message <= 0) throw new IllegalArgumentException();
        //--implementation как?--

        message = 27598;
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
