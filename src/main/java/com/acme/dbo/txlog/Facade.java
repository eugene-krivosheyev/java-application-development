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

    private static Integer intAccumulator = null;
    private static Integer stringAccumulator = 0;
    private static String logMessage = null;

    public static void log(int obj) {
        if (intAccumulator == null){
            intAccumulator = obj;
        }else{
            intAccumulator += obj;
        }
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
        if (logMessage == null){
            logMessage = obj;
        }
        if (!obj.equals(logMessage)){
            flush();
        }
        stringAccumulator += 1;
        logMessage = obj;
    }

    public static void log(Object obj) {
        print(REFERENCE, obj);
    }

    public static void print(String prefix, Object obj) {
        System.out.println(prefix + ": " + obj.toString());
    }

    public static void flush() {
        if (intAccumulator != null){
            print(PRIMITIVE, intAccumulator);
            intAccumulator = null;
            //stringAccumulator = 0;
        }
        if (stringAccumulator != 0){
            if (stringAccumulator == 1){
                print(STRING, logMessage);
            }else {
                print(STRING, logMessage + " (x" + stringAccumulator + ")");
            }
            //intAccumulator = null;
            stringAccumulator = 0;
        }

    };

}
// single-line
