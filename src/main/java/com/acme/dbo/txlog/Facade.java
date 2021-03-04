package com.acme.dbo.txlog;

import static com.acme.dbo.txlog.ConsoleOutput.sysOut;

public class Facade {
    public static void log(int message) {
        sysOut(message);
    }

    public static void log(byte message) {
        sysOut(message);
    }
}
