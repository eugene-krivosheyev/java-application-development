package com.acme.dbo.txlog;

import static com.sun.deploy.trace.Trace.flush;

public class Facade {
    public static final String PRIMITIVE_PREFIX = "primitive: ";
    public static final String STRING_PREFIX = "string: ";
    private static final String PRIMITIVE_POSTFIX = "";
    private static final String STRING_POSTFIX = "";
    private static String type = "null";
    private static int cumulativeIntLog = 0;
    private static byte cumulativeByteLog = 0;

    public static void log(int message) {
        if (type != "int") {
            flush();
            type = "int";
            cumulativeIntLog = message;
        } else {
            if(Integer.MAX_VALUE - message >=cumulativeIntLog) {
            cumulativeIntLog += message;
            else {
                flush();
                log(message);
        }
    }

    public static void flush() {
        if (type == "int") {
            print(PRIMITIVE_PREFIX, message, PRIMITIVE_POSTFIX));
            } else if (type == "byte") {
            print(PRIMITIVE_PREFIX + cumulativeByteLog);
             }
        type = "null";
    }

    public static void log(byte message) {

        print(decorate(PRIMITIVE_PREFIX, message, PRIMITIVE_POSTFIX));
    }

    /*public static void log(String message) {
        print(decorate(STRING_PREFIX, message, STRING_POSTFIX));
    }


    private static void print(Object message)  {
        print(decorate("", message, ""));
    }
*/
    private static String decorate(String prefix, Object message, String postfix) {
        return prefix + message + postfix;
    }

}
