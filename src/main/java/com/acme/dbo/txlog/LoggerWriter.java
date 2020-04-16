package com.acme.dbo.txlog;

import com.acme.dbo.txlog.message.MessageBase;

import java.io.PrintStream;

public class LoggerWriter{

    private PrintStream writer;

    public LoggerWriter(PrintStream writer){
        this.writer = writer;
    }

    public void log(MessageBase messageBase){
        writer.println(messageBase.toString());
    }
}