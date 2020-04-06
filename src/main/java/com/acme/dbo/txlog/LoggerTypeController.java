package com.acme.dbo.txlog;

public class LoggerTypeController {

    LogWriter writer;

    private ByteCommand lastByteCommand;
    private IntCommand lastIntCommand;
    private StringCommand lastStringCommand;

    public LoggerTypeController(LogWriter writer) {
        this.writer = writer;
    }

    public void log(IntCommand command) {
        if(lastIntCommand==null) flush();
        IntCommand newCommand = command.process(lastIntCommand);
        if (newCommand == null) {
            flush();
            lastIntCommand = command;
        } else {
            lastIntCommand = newCommand;
        }
    }

    public void log(ByteCommand command) {
        if(lastByteCommand==null) flush();
        ByteCommand newCommand = command.process(lastByteCommand);
        if (newCommand == null) {
            flush();
            lastByteCommand = command;
        } else {
            lastByteCommand = newCommand;
        }
    }

    public void log(CharCommand command) {
        flush();
        writer.write(command.getDecoratedMessage());
    }

    public void log(BooleanCommand command) {
        flush();
        writer.write(command.getDecoratedMessage());
    }

    public void log(ObjectCommand command) {
        flush();
        writer.write(command.getDecoratedMessage());
    }

    public void log(StringCommand command) {
        if(lastStringCommand==null) flush();
        StringCommand newCommand = command.process(lastStringCommand);
        if (newCommand == null) {
            flush();
            lastStringCommand = command;
        } else {
            lastStringCommand = newCommand;
        }
    }

    public void flush() {
        if (lastStringCommand != null) {
            writer.write(lastStringCommand.getDecoratedMessage());
            lastStringCommand = null;
        } else if (lastByteCommand != null) {
            writer.write(lastByteCommand.getDecoratedMessage());
            lastByteCommand = null;
        } else if (lastIntCommand != null) {
            writer.write(lastIntCommand.getDecoratedMessage());
            lastIntCommand = null;
        }
    }
}