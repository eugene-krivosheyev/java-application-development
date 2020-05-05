package com.acme.dbo.txlog;

import com.acme.dbo.txlog.commands.ByteCommand;
import com.acme.dbo.txlog.commands.IntCommand;
import com.acme.dbo.txlog.commands.StrCommand;
import com.acme.dbo.txlog.controllers.LogController;
import com.acme.dbo.txlog.exceptions.LoggingException;
import com.acme.dbo.txlog.exceptions.WriteException;
import com.acme.dbo.txlog.writers.LogWriterFactory;

public class Facade {

    private static final LogController logController = new LogController(LogWriterFactory.create());

    public static void log(int message) throws LoggingException {
        logController.log(new IntCommand(message));
    }

    public static void log(byte message) throws LoggingException {
        logController.log(new ByteCommand(message));
    }

    public static void log(String message) throws LoggingException {
        logController.log(new StrCommand(message));
    }

    public static void close() throws LoggingException {
            logController.close();
    }
}