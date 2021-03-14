/**
 * jkgjdhkgjhdfkgjdhfk
 */
package com.acme.dbo.txlog;

import javax.security.auth.*;
import java.util.stream.IntStream;

/**
 * Facade
 *
 * @author kjghdkfjghdkfjhg
 * @since 1.0
 */

public class Facade {
    public static int переменнаяИзНескольктихСлов; //static, global
    public static final int MY_CONST = 2;

    /**
     * message != null
     */
    //@Contract(!null -> !null)
    public static void log(/* @NotNull */ int message) { //formal arg
        printToConsole(message);
    }

    public static void log(byte message) {
        printToConsole(message);
    }

    public static void log(Object message) {
        System.out.println("reference: " + message);
    }

    public static void log(String message1, String message2) {

    }


    private static void printToConsole(int message) {
        logPrimitivePrefix();
        System.out.println(message);
    }

    public static void log(char message) {
        System.out.println("char: " + message);
    }

    public static void log(String message) {
        System.out.println("string: " + message);
    }

    public static void log(boolean message) {
        logPrimitivePrefix();
        System.out.println(message);
    }

    private static void logPrimitivePrefix() {
        System.out.print("primitive: ");
    }
}
