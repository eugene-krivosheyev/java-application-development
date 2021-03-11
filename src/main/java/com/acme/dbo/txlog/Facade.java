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

    /**
     * message != null
     */
    //@Contract(!null -> !null)
    public static void log(/* @NotNull */ int message) { //formal arg
        printToConsole("primitive: " + message + '\n');
    }

    public static void log(char message) {
        printToConsole("char: " + message);
    }

    public static void log(byte message) {
        printToConsole("primitive: " + message);
    }

    public static void log(String message) {
        printToConsole("string: " + message);
    }

    public static void log(boolean message) {
        printToConsole("primitive: " + message + '\n');
    }

    public static void log(Object message) {
        printToConsole("reference: @" + message + '\n');;
    }

    public static void log(String message1, String message2) {

    }

    private static void printToConsole(String message) {
        System.out.print(message);
    }
}
// single-line
