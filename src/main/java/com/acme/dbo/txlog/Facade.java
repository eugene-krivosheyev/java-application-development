package com.acme.dbo.txlog;

import static com.acme.dbo.txlog.FacadePrefixes.*;
import static com.acme.dbo.txlog.FacadePrefixes.INT_PREFIX;

public class Facade {

    public static void log( int message ) {
        System.out.println(INT_PREFIX + message);
    }

    public static void log( byte message ) {
        System.out.println(BYTE_PREFIX + message);
    }

    public static void log( char message ) {
        System.out.println(CHAR_PREFIX + message);
    }

    public static void log( String message ) {
        System.out.println(STRING_PREFIX + message);
    }

    public static void log( boolean message ) {
        System.out.println(BOOLEAN_PREFIX + message);
    }

    public static void log( Object message ) {
        System.out.println(REFERENCE_PREFIX + message.toString());
    }

}
