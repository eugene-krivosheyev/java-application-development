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
    public static final String PRIMITIVE = "primitive";
    public static final String CHAR = "char";
    public static final String STRING = "string";
    public static final String REFERENCE = "reference";

    public static void log(int obj) {
        print(PRIMITIVE, obj);
    }

    public static void log(byte obj) {
        print(PRIMITIVE, obj);
    }

    public static void log(Boolean obj) {
        print(PRIMITIVE, obj);
    }

    public static void log(char obj) {
        print(CHAR, obj);
    }

    public static void log(String obj) {
        print(STRING, obj);
    }

    public static void log(Object obj) {
        print(REFERENCE, obj);
    }

    public static void print(String prefix, Object obj) {
        System.out.println(prefix + ": " + obj.toString());
    }

}
// single-line
