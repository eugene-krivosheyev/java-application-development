package com.acme.dbo.txlog;

import static com.acme.dbo.txlog.ConsoleOutputDecorator.sysPrimitiveOut;

public class Facade {
    public static void log(int message) {
        sysPrimitiveOut(message);
    }

    public static void log(byte message) {
        sysPrimitiveOut(message);
    }
}
