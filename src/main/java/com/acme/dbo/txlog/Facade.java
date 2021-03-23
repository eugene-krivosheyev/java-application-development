package com.acme.dbo.txlog;

import static com.acme.dbo.txlog.OutputDecorator.logOutput;

public class Facade {
    static String stringAccumulator=null;
    static int intAccumulator=0;
    static byte byteAccumulator=0;
    static enum Type {INT, BYTE, STRING};
    static Type currentType=null;
    static String currentMessage=null;

    public static void log(byte message) {
        logOutput(message);
    }

    public static void log(int message) {
        if (currentType == Type.INT) {
            long leftInteger=((long) intAccumulator + (long) message)% Integer.MAX_VALUE;
            if (leftInteger!=0) {
                logOutput(Integer.MAX_VALUE);
                currentMessage= Long.toString(leftInteger);
                intAccumulator=(int) leftInteger;
                flush();
            } else {
                intAccumulator += message;
            }
            return;
        }
        if (currentType==null) {
           // currentMessage = message;
            flush();
        }

        currentType = Type.INT;
        intAccumulator=message;
        currentMessage = Integer.toString(intAccumulator);
        //logOutput(message);
    }

    public static void log(char message) {
        logOutput(message);
    }

    public static void log(String message) {
        logOutput(message);
    }

    public static void log(Object message) {
        logOutput(message);
    }

    public static void log(boolean message) {
        logOutput(message);
    }

    public static void flush()
    {
        logOutput(currentMessage);
        currentMessage=null;
    };
}
