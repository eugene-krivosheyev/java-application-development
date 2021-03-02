package com.acme.dbo.txlog;

import static com.acme.dbo.txlog.Facade.log;
import static java.lang.Math.PI;


/**
 *
 */
public class Application {
    public static void main(String[] args) {
        System.out.println(args);
        int mainLocalValue = 1;
        //........
        //........
        while (notAlwaysTrue()) {

        }
        //........
        //........
        //........
        new Facade();

        final int message = 1; //factual arg
        log(message);
        System.out.println(message);
        //...
        //...
        //ClassLoader.unload(Facade.class)
        //......
        //......
        //......
    }

    private static boolean notAlwaysTrue() {
        return false;
    }
}
