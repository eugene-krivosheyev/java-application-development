package com.acme.dbo.txlog;

import com.acme.dbo.txlog.message.MessageBase;
import com.acme.dbo.txlog.message.MessageConverter;
import com.acme.dbo.txlog.message.processor.MessageProcessor;

import java.io.IOException;


public final class Facade {

    private static MessageProcessor messageProcessor;
    private static LogWriter logWriter;

    private Facade() {
    }

    public static void init(MessageProcessor messageProcessor, LogWriter logWriter) {
        Facade.messageProcessor = messageProcessor;
        Facade.logWriter = logWriter;
        messageProcessor.setCallBack(m -> logMessage(m));
    }

    public static void log(byte message) {
        messageProcessor.accept(MessageConverter.toMessage(message));
    }

    public static void log(int message) {
        messageProcessor.accept(MessageConverter.toMessage(message));
    }

    public static void log(boolean message) {
        messageProcessor.accept(MessageConverter.toMessage(message));
    }

    public static void log(char message) {
        messageProcessor.accept(MessageConverter.toMessage(message));
    }

    public static void log(String message) {
        messageProcessor.accept(MessageConverter.toMessage(message));
    }

    public static void log(String... message) {
        for (String ss : message) {
            messageProcessor.accept(MessageConverter.toMessage(ss));
        }
        flush();
    }

    public static void log(int... message) {
        messageProcessor.accept(MessageConverter.toMessage(message));
    }

    public static void log(int[][] message) {
        messageProcessor.accept(MessageConverter.toMessage(message));
    }

    public static void log(int[][][][] message) {
        messageProcessor.accept(MessageConverter.toMessage(message));
    }

    public static void log(Object message) {
        messageProcessor.accept(MessageConverter.toMessage(message));
    }

    public static void flush() {
        try {
            messageProcessor.flush();
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    public static void logMessage(MessageBase message) {
        logWriter.println(message);
    }
}
