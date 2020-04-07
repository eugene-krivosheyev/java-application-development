package com.acme.dbo.txlog;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.Writer;

public class Facade1 {

    private static Byte byteAccumulator;
    private static Integer intAccumulator;
    private static String stringAccumulator;
    private static int stringCounter;

    private static PrintStream printStream = System.out;


    public static PrintStream getPrintStream(){
        return printStream;
    }

//    public static void setPrintStream(PrintStream printStream) {
//        PrintStream old = Facade.printStream;
//        Facade.printStream = printStream;
//        old.flush();
//    }


    public static void logPrint(String msg) {

    }

    public static void log(int message) {
        logByteAccums();
        logStringAccums();

        if (intAccumulator == null) {
            intAccumulator = message;
        }
        else {
            int sum = intAccumulator + message;
            if (message > 0 && sum > intAccumulator || message < 0 && sum < intAccumulator) {
                intAccumulator = sum;
            }
            else {
                logIntAccums();
                logSimple(message);
            }
        }
    }

    public static void log(byte message) {
        logStringAccums();
        logIntAccums();
        if (byteAccumulator == null) {
            byteAccumulator = message;
        } else {
            byte sum = (byte) (byteAccumulator + message);
            if (message > 0 && sum > byteAccumulator || message < 0 && sum < byteAccumulator) {
                byteAccumulator = sum;
            } else {
                logByteAccums();
                logSimple(message);
            }
        }
    }

    public static void log(String message) {
        logByteAccums();
        logIntAccums();

        if (stringAccumulator == null) {
            stringAccumulator = message;
            stringCounter = 1;

        } else if (!stringAccumulator.equals(message)) {
            logStringAccums();
            stringAccumulator = message;
            stringCounter = 1;
        } else {
            stringCounter++;
        }
    }

    public static void log(Object o) {
        logByteAccums();
        logIntAccums();
        logStringAccums();
        logPrint("" + o.toString());
    }

    public static void log(boolean message) {
        logByteAccums();
        logIntAccums();
        logStringAccums();
        logPrint("" + message);
    }

    public static void log(char message) {
        logByteAccums();
        logIntAccums();
        logStringAccums();
        logPrint("" + message);
    }

    public static void flush() {
        logStringAccums();
        logByteAccums();
        logIntAccums();
    }

    private static void logSimple(int message) {
        logPrint("" + message);
    }


    private static void logByteAccums() {
        if (byteAccumulator != null) {
            logSimple(byteAccumulator);
            byteAccumulator = null;
        }
    }

    private static void logIntAccums() {

        if (intAccumulator != null) {
            logSimple(intAccumulator);
            intAccumulator = null;
        }
    }

    private static void logStringAccums() {
        if (stringAccumulator != null) {
            logSimple(stringAccumulator + (stringCounter > 1 ? (" (x" + stringCounter + ")") : ""));
            stringAccumulator = null;
        }
    }

    private static void logSimple(byte message) {
        logPrint("" + message);
    }

    private static void logSimple(String message) {
        logPrint("" + message);
    }



}
