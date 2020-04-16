package com.acme.dbo.txlog;

import com.acme.dbo.txlog.logger.LoggerBase;
import com.acme.dbo.txlog.message.*;

import java.io.PrintStream;

public class Facade {
    private static final String PRIMITIVE = "primitive";

    static LoggerWriter writer = new LoggerWriter(System.out);

    public static void log(byte message) {
        writer.log(new PrefixMessage(PRIMITIVE, new ByteMessage(message)));
    }

    public static void log(int message) {
         writer.log(new PrefixMessage(PRIMITIVE, new IntMessage(message)));
    }

    public static void log(boolean message) {
        writer.log(new PrefixMessage(PRIMITIVE, new BoolMessage(message)));
    }

    public static void log(char message) {
        writer.log(new PrefixMessage("char", new CharMessage(message)));
    }

    public static void log(String message) {
        writer.log(new PrefixMessage("string", new StringMessage(message)));
    }

    public static void log(Object message) {
        writer.log(new PrefixMessage("reference", new ObjectMessage(message)));
    }
}
