package com.acme.dbo.txlog;

import com.acme.dbo.txlog.command.*;

enum LogType {
    INT("primitive"), BOOL("primitive"), BYTE("primitive"),
    CHAR("char"), STR("string"), OBJ("reference"),
    MATRIX("primitives matrix"), MULTIMATRIX("primitives multimatrix"),
    SERVICE("");

    private String prefix;

    LogType(String prefix) {
        this.prefix = prefix;
    }

    public String getPrefix() {
        return prefix;
    }
}

public class LogController {
    private LogType previousLogType = LogType.SERVICE;
    private Object Value;
    private int StringCounter;

    public void log(IntegerCommand command) {
        if (tryToPrintThePreviousValue(LogType.INT))
            if (command.isCumulative((IntegerCommand) Value)) Value = command.accumulateWith((IntegerCommand) Value);
            else {
                print();
                Value = command;
            }
        else Value = command;
    }

    public void log(CharCommand message) {
        if (tryToPrintThePreviousValue(LogType.CHAR)) print();
        Value = message;
    }

    public void log(StringCommand command) {
        if (tryToPrintThePreviousValue(LogType.STR) && !command.isCumulative((StringCommand) Value)) print();
        Value = command;
        StringCounter++;
    }

    public void log(BoolCommand command) {
        if (tryToPrintThePreviousValue(LogType.BOOL)) print();
        Value = command;
    }

    public void log(ObjectCommand command) {
        if (tryToPrintThePreviousValue(LogType.OBJ)) print();
        Value = command;
    }

    public void log(ByteCommand command) {
        if (tryToPrintThePreviousValue(LogType.BYTE))
            if (command.isCumulative((ByteCommand) Value)) Value = command.accumulateWith((ByteCommand) Value);
            else {
                print();
                Value = command;
            }
        else Value = command;
    }

    public void log(MatrixCommand command) {
        if (tryToPrintThePreviousValue(LogType.MATRIX)) print();
        Value = command;
        print();
    }

    public void log(MultiMatrixCommand command) {
        if (tryToPrintThePreviousValue(LogType.MULTIMATRIX)) print();
        Value = command;
        print();
    }

    public void stop() {
        print();
        previousLogType = LogType.SERVICE;
    }

    private void print() {
        if (Value != null) {
            if (StringCounter > 1) Value = Value.toString() + " (x" + StringCounter + ")";
            System.out.println(previousLogType.getPrefix() + ": " + Value);
            Value = null;
            StringCounter = 0;
        }
    }

    private boolean tryToPrintThePreviousValue(LogType currentLogType) {
        if (currentLogType.equals(previousLogType)) return true;
        print();
        previousLogType = currentLogType;
        return false;
    }
}
