package com.acme.dbo.txlog;

import com.acme.dbo.txlog.commands.ByteCommand;
import com.acme.dbo.txlog.commands.IntCommand;
import com.acme.dbo.txlog.commands.StrCommand;
import com.acme.dbo.txlog.controllers.LogController;
import com.acme.dbo.txlog.writers.LogWriter;

public class Facade {

    private static LogController logController = new LogController(new LogWriter());

    public static void log(int message) {
        logController.log(new IntCommand(message));
    }

    public static void log(byte message) {
        logController.log(new ByteCommand(message));
    }

//    public static void log(boolean message) {
//        logPrimitive(message);
//    }

//    public static void log(Object message) {
//        logReference(message);
//    }

//    public static void log(char message) {
//        logChar(message);
//    }

    public static void log(String message) {
        logController.log(new StrCommand(message));
    }

    public static void close() {
        logController.close();
    }
}