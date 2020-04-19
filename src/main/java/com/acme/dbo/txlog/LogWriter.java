package com.acme.dbo.txlog;

import com.acme.dbo.txlog.message.MessageBase;

import java.io.PrintStream;

public class LogWriter {

    private PrintStream writer;

    public LogWriter(PrintStream writer){
        this.writer = writer;
    }

    public void println(MessageBase messageBase) {
        writer.println(messageBase.toString());
    }
}