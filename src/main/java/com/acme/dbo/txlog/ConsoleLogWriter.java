package com.acme.dbo.txlog;

import com.acme.dbo.txlog.Command;

public class ConsoleLogWriter implements LogWriter{

    @Override
    public void write (Command command) {
        String message = command.decoratedMessage();
        if(message != null)
            System.out.println(command.decoratedMessage());
    }
}
