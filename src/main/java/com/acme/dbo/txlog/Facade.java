package com.acme.dbo.txlog;

public class Facade {

    private static Byte s_byteAccum;
    private static Integer s_intAccum;
    private static String s_stringAccum;
    private static int s_stringCounter;

    public static void logPrint(String msg) {System.out.println(msg); }
    private static void logSimple(String message){
        logPrint("" + message);
    }

    public static void clear(){
        logStringAccums();
        logByteAccums();
        logIntAccums();
    }


    private static void logByteAccums() {
        if (s_byteAccum != null) {
            logSimple(s_byteAccum);
            s_byteAccum = null;
        }
    }
    private static void logIntAccums() {

        if (s_intAccum != null) {
            logSimple(s_intAccum);
            s_intAccum = null;
        }
    }
    private static void logStringAccums(){
        if(s_stringAccum!=null){
            logSimple(s_stringAccum+(s_stringCounter>1?(" (x"+s_stringCounter+")"):""));
            s_stringAccum=null;
        }
    }


    public static void log(int message) {
        logByteAccums();
        logStringAccums();

        if (s_intAccum==null){
            s_intAccum=message;
        }else{
            int sum=s_intAccum+message;
            if(message>0 && sum>s_intAccum || message<0 && sum<s_intAccum){
                s_intAccum=sum;
            }
            else{
                logIntAccums();
                logSimple(message);
            }
        }


    }

    private static void logSimple(int message){
        logPrint(""+message);
    }

    public static void log(byte message) {
        logStringAccums();
        logIntAccums();
        if (s_byteAccum == null) {
            s_byteAccum = message;

        } else {
            byte sum=(byte)(s_byteAccum+message);
            if(message>0 && sum>s_byteAccum || message<0 && sum<s_byteAccum){
                s_byteAccum=sum;
            }
            else{
                logByteAccums();
                logSimple(message);
            }
        }
    }

     private static void logSimple(byte message){
        logPrint("" + message);
    }



    public static void log(String message) {
        logByteAccums();
        logIntAccums();

        if (s_stringAccum == null) {
            s_stringAccum = message;
            s_stringCounter = 1;

        } else if (!s_stringAccum.equals(message)) {
            logStringAccums();
            s_stringAccum = message;
            s_stringCounter = 1;
        } else {
            s_stringCounter++;
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
}
