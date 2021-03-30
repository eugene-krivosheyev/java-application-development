package com.acme.dbo.txlog;

enum Type {
    INTEGER,
    BYTE,
    STRING
}

public class Facade {

    private static String stringAccumulator = null;
    private static int stringCount = 0;
    private static byte byteAccumulator = 0;
    private static int intAccumulator = 0;

    private static Type currentType = null;

    static OutputDecorator logger = new OutputDecorator(new ConsoleLogger());

    public static void log(int message) {
        if (currentType != Type.INTEGER) {
            close();
            currentType = Type.INTEGER;
            intAccumulator = message;
            return;
        }

        long left = ((long) intAccumulator + (long) message) - Integer.MAX_VALUE;

        if (left > 0) {
            logger.log(Integer.MAX_VALUE);
            intAccumulator = (int) left;
            return;
        }

        intAccumulator += message;
    }

    public static void log(byte message) {
        if (currentType != Type.BYTE) {
            close();
            currentType = Type.BYTE;
            byteAccumulator = message;
            return;
        }

        long left = ((long) byteAccumulator + (long) message) - Byte.MAX_VALUE;

        if (left > 0) {
            logger.log(Byte.MAX_VALUE);
            byteAccumulator = (byte) left;
            return;
        }

        byteAccumulator += message;
    }

    public static void log(char message) {
        logger.log(message);
    }

    public static void log(boolean message) {
        logger.log(message);
    }

    public static void log(Object message) {
        logger.log(message);
    }

    public static void log(String message) {
        if (currentType != Type.STRING) {
            close();
            currentType = Type.STRING;
            stringAccumulator = message;
            stringCount = 1;
            return;
        }

        if (stringAccumulator == message) {
            stringCount++;
        } else {
            close();
            stringCount = 1;
            stringAccumulator = message;
        }
    }

    public static void log(int[] message) {
        logger.log(message);
    }

    public static void log(int[][] message) {
        logger.log(message);
    }

    public static void log(String ...message) {
        for (String str : message) {
            Facade.log(str);
        }
    }

    public static void close() {
        if (currentType == null) {
            return;
        }

        switch (currentType) {
            case BYTE:
                logger.log(byteAccumulator);
                break;
            case INTEGER:
                logger.log(intAccumulator);
                break;
            case STRING:
                String message = stringCount > 1 ? stringAccumulator + " (x" + stringCount + ")" : stringAccumulator;
                if (stringAccumulator != null) {
                    logger.log(message);
                }
                break;
        }

        intAccumulator = 0;
        byteAccumulator = 0;
        stringAccumulator = null;
    }


}
