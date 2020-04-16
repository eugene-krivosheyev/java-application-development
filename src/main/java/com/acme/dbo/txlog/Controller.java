package com.acme.dbo.txlog;

import com.acme.dbo.txlog.command.Command;

public class Controller {
    private Command command;

    private Command lastCommand;
    private Writer writer = new Writer();

    private int duplicateCount;


    void log(Command command) {
        if (lastCommand != null) {
            if ((command.getClass().equals(lastCommand.getClass()))) {
                command = command.accumulate(this, lastCommand);
                if ((lastCommand != null) && (lastCommand.getCurrentValue().equals(command.getCurrentValue()))) {
                    duplicateCount++;
                    command = lastCommand;
                } else {
                    command = command.accumulate(this, lastCommand);
                    duplicateCount = 0;
                }
            } else {
                flush();
            }
        }
        lastCommand = command;
    }

    public void flush() {
        if (lastCommand != null) {
            writer.write(lastCommand.getDecoratedState(duplicateCount));
            lastCommand.flush();
            duplicateCount = 0;
        }
        lastCommand = null;
    }
}