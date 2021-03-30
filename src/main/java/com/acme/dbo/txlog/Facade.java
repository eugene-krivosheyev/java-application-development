package com.acme.dbo.txlog;

import java.util.Arrays;

import static com.acme.dbo.txlog.FacadePrefixes.*;
import static com.acme.dbo.txlog.FacadePrefixes.INT_PREFIX;
import static java.lang.System.lineSeparator;

public class Facade {
    private static String currentLogState = "null";
    private static int cumulativeIntLog = 0;
    private static byte cumulativeByteLog = 0;
    private static String cumulativeStringLog = "";
    private static int cumulativeStringLogCounter = 0;

    public static void log( int message ) {
        if (currentLogState != "int") {
            flush();
            currentLogState = "int";
            cumulativeIntLog = message;
        } else {
            if(sumNotOverflowGivenLimit(cumulativeIntLog, message, Integer.MAX_VALUE)){
                cumulativeIntLog += message;
            } else {
                flush();
                log(message);
            }
        }
    }

    
    private static boolean sumNotOverflowGivenLimit(int num1, int num2, int limit ) {
        return limit - num2 >= num1;
    }

    public static void flush() {
        if (currentLogState == "int") {
            print(INT_PREFIX + cumulativeIntLog);
        } else if (currentLogState == "byte"){
            print(BYTE_PREFIX + cumulativeByteLog);
        } else if (currentLogState == "String"){
            print(STRING_PREFIX + stringFormat());
        }
        currentLogState = "null";
    }

    public static void log( byte message ) {
        if (currentLogState != "byte") {
            flush();
            currentLogState = "byte";
            cumulativeByteLog = message;
        } else {
            if(sumNotOverflowGivenLimit(cumulativeByteLog, message, Byte.MAX_VALUE)){
                cumulativeByteLog += message;
            } else {
                flush();
                log(message);
            }
        }
    }

    public static void log( char message ) {
        flush();
        print(CHAR_PREFIX + message);
    }

    public static void log( String message ) {
        if (currentLogState != "String"){
            flush();
            currentLogState = "String";
            cumulativeStringLog = message;
            cumulativeStringLogCounter = 1;
        } else {
            if (cumulativeStringLog == message && cumulativeStringLogCounter > 0){
                cumulativeStringLogCounter++;
            } else {
                flush();
                currentLogState = "String";
                cumulativeStringLog = message;
            }
        }
    }

    public static void log( boolean message ) {
        flush();
        print(BOOLEAN_PREFIX + message);
    }

    public static void log( Object message ) {
        flush();
        print(REFERENCE_PREFIX + message.toString());
    }

    public static void log(int [] message){
        flush();
        print(ARRAY_PREFIX + replaceHooks(message));
    }

    public static void log(int [][] message){
        flush();
        print(MATRIX_PREFIX + "{");
        for (int[] ints : message) {
            print(replaceHooks(ints));
        }
        print("}");
    }

    private static String replaceHooks( int[] ints ) {
        return Arrays.toString(ints)
                .replace('[', '{')
                .replace(']', '}');
    }

    private static void print( String message ) {
        System.out.println(message);
    }

    private static String stringFormat(){
        return cumulativeStringLogCounter > 1 ? cumulativeStringLog + " (x" + cumulativeStringLogCounter + ")" : cumulativeStringLog;
    }


}
