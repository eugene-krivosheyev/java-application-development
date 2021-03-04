package com.acme.dbo.txlog;

import java.util.List;

public class Facade {
    public static void log(Object message) {
        System.out.println("primitive: " + message);
    }

}
