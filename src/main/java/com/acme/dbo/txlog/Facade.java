package com.acme.dbo.txlog;

public class Facade {

    public static void logPrint(String msg) { System.out.println(msg);}

    public static void log(int message) {
        logPrint("primitive: " + message);
    }

    public static void log(byte message) {
        logPrint("primitive: " + message);
    }

   public static void log(boolean message) {
        logPrint("primitive: " + message);
   }

    public static void log(char message) {
       logPrint("char: " + message);
    }

    public static void log(String message) {
        logPrint("string: " + message);
    }

public static void log(Object o)
{
    logPrint("reference: " + o.toString());}
}
