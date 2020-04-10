package com.acme.dbo.txlog;



public class Facade {
    private static final String PREFIX_PRIMITIVE = "primitive: ";
    private static final String PREFIX_PREFERNCE = "reference: ";
    private static final String PREFIX_STRING = "string: ";
    private static final String PREFIX_CHAR = "char: ";
    private static String msgType = "Blank";
    private static Integer intAccum;
    private static Byte byteAccum;
    private static int stringCounter = 1;
    private static String stringAccum;
    static private Controller controller = new Controller(new LogWriter());


    public static void flush() {
        controller.flush();
  /*      if (stringAccum != null) {

            String message = stringAccum + (stringCounter > 1 ? (" (x" + stringCounter + ")") : "");
            System.out.println(PREFIX_STRING + message);
            stringCounter = 1;
            stringAccum = null;
        } else if (byteAccum != null) {
            System.out.println(PREFIX_PRIMITIVE + (byte) byteAccum);
            byteAccum = null;
        } else if (intAccum != null) {
            System.out.println(PREFIX_PRIMITIVE + (int) intAccum);
            intAccum = null;
        }
*/
    }

    public static void log(String message) {
        controller.log(new CommandString(message));

  /*      if (!message.equals(stringAccum)) {
            flush();
        } else {
            stringCounter++;
        }

        stringAccum = message;
    */
    }
    public static void log(int message) {
controller.log(new CommandInt(message));
        /*
        if ((intAccum != null) &&
                checkNotOverMaxInt(message, intAccum)) {
            intAccum = intAccum + message;
        } else {
            flush();
            intAccum = message;
        }*/
    }



    private static boolean checkNotOverMaxInt(int a, int b) {
        return (a >= 0 && a + b >= b || a < 0 && a + b < b);
    }


    public static void log(byte message) {
        if ((byteAccum != null) && (checkNotOverMaxByte(message, byteAccum))) {
            byteAccum = (byte) (byteAccum + message);
        } else {
            flush();
            byteAccum = message;
        }
    }


    private static boolean checkNotOverMaxByte(byte a, byte b) {
        return (a >= 0 && (byte) (a + b) >= b || a < 0 && (byte) (a + b) < b);
    }


    public static void log(boolean message) {
        System.out.println(PREFIX_PRIMITIVE + message);
    }

    public static void log(char message) {
        System.out.println(PREFIX_CHAR + message);
    }

    public static void log(Object message) {
        System.out.println(PREFIX_PREFERNCE + message);
    }

}
