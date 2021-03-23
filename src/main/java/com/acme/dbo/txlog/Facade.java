package com.acme.dbo.txlog;

public class Facade {

    private static Object lastObject = null;

    // check object. accumulate if required
    public static void log(Object obj) {
        if (null == lastObject) {
            lastObject = obj;
        } else if(obj.getClass() != lastObject.getClass()) {
            flush();
            lastObject = obj;
        } else if (obj instanceof Integer) {
            long lObj = ((Integer)obj).longValue();
            long lLastObj = ((Integer)lastObject).longValue();
            long sum = lObj + lLastObj;

            if(sum > Integer.MAX_VALUE) {
                flush();
                lastObject = obj;
            } else {
                lastObject = sum;
            }
        } else {
            flush();
            lastObject = obj;
        }

    }

    private static void logInternal(Object obj) {
        printMessage(decorate(obj));
    }

    // if we have accumulated value -
    public static void flush() {
        if(null != lastObject) {
            logInternal(lastObject);
            lastObject = null;
        }
    }

    private static Object accumulate(Object obj) {
        if (obj.getClass() != lastObject.getClass()) {
            flush();
        }

        return obj;
    }

    private static String decorate(Object message) {
        String prefix = "reference: "; // default one, if need custom case - modify below

        if ((message instanceof Integer) || (message instanceof Byte) || (message instanceof Boolean)) {
            prefix = "primitive: ";
        } else if (message instanceof String ) {
            prefix = "string: ";
        } else if (message instanceof Character) {
            prefix = "char: ";
        }

        return prefix + message;
    }

    private static void printMessage(String msg) {
        System.out.println(msg);
    }
}
