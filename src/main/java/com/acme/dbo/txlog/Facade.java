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
    public static int переменнаяИзНескольктихСлов = 0; //static, global
    public static final int MY_CONST = 2;
    public static final int MY_SECOND_CONST = 1;

    /*
    static {
        System.out.println("static block");
//        new IntStream("file"); // -> exception?
        //....
    }

    static {
        System.out.println("vvv");
        //....
    }
*/
    /**
     * message != null
     */
    //@Contract(!null -> !null)
    public static void log(/* @NotNull */ int message) { //formal arg
//        int i喝шш = 1; //stack, auto, local
//        System.out.println(i喝шш);
//
//        System.out.println(переменнаяИзНескольктихСлов);
//        if (message <= 0) throw new IllegalArgumentException();
//        --implementation как?--
//
//        message = 27598;
        final int localConst = 2;
        int localVar = 0;
        System.out.println(localVar);

        byte byteVar = 1;

        String stringVar = "some string const literal";
        printMessage(message);
        //...
    }

    public static void log(byte message) {
        printMessage(message);
    }

    public static void log(String message) {
        printMessage(message);
    }

    private static void printMessage(Object message) {
        System.out.println(message);
    }


}
// single-line
