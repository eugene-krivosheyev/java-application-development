package com.acme.dbo.txlog;

public class Facade {

    public static void log (Object message){
        if ((message instanceof Integer)|(message instanceof Byte)|(message instanceof Boolean)) {
            System.out.println("primitive: " + message);
        }
        else if ((message instanceof Character)) {
            System.out.println("char: " + message);
        }
        else if ((message instanceof String)) {
            System.out.println("string: " + message);
        }
        else {
            System.out.println("reference: " + message);
        }
    }

}
