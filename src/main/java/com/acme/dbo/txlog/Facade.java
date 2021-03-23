package com.acme.dbo.txlog;

import static com.acme.dbo.txlog.FacadePrefixes.*;
import static com.acme.dbo.txlog.FacadePrefixes.INT_PREFIX;

public class Facade {

    private static String type = "null";
    private static int cumulativeIntLog = 0;
    private static byte cumulativeByteLog = 0;

    public static void log( int message ) {
        if (type != "int") {
            type = "int";
            cumulativeIntLog = message;
        } else {
            if(Integer.MAX_VALUE - message >= cumulativeIntLog){
                cumulativeIntLog += message;
            } else {
                flush();
                log(message);
                //cumulativeIntLog = message;
            }
        }
        //print(INT_PREFIX + message);
    }

    public static void flush() {
        if (type == "int") {
            print(INT_PREFIX + cumulativeIntLog);
            type = "null";
        } else if (type == "byte"){
            print(BYTE_PREFIX + cumulativeByteLog);
            type = "null";
        }
        type = "null";

    }

    public static void log( byte message ) {
        type = "byte";
        print(BYTE_PREFIX + message);
    }

    public static void log( char message ) {
        type = "char";
        print(CHAR_PREFIX + message);
    }

    public static void log( String message ) {
        flush();
        type = "String";
        print(STRING_PREFIX + message);
    }

    public static void log( boolean message ) {
        type = "boolean";
        print(BOOLEAN_PREFIX + message);
    }

    public static void log( Object message ) {
        type = "Object";
        print(REFERENCE_PREFIX + message.toString());
    }

    private static void print( String message ) {
        System.out.println(message);
    }


}
