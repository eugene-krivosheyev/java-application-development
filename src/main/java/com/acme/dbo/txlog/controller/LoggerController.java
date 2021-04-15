package com.acme.dbo.txlog.controller;

import com.acme.dbo.txlog.message.*;
import com.acme.dbo.txlog.printer.Printer;

import static  com.acme.dbo.txlog.controller.AccumulatorState.*;


public class LoggerController {
    private AccumulatorState currentState = NONE;
    private Message currentValue;
    private Printer printer;

    public LoggerController(Printer printer) {
        this.printer = printer;
        this.currentValue = new NullMessage();
    }

    public void log(StringMessage message) {
        if (!(currentState.equals(STRING)) | !(message.isValueEqual(currentValue))) {
            flush(message);
            currentState = STRING;
        }
        currentValue = currentValue.accumulate(message);
    }

    public void log(IntMessage message) {
        if (!currentState.equals(INT) | currentValue.isNumberOverflow(message)) {
            flush(message);
            currentState = INT;
        }
        currentValue = currentValue.accumulate(message);
    }

    public void log(ByteMessage message) {
        if (!currentState.equals(BYTE) | currentValue.isNumberOverflow(message)) {
            flush(message);
            currentState = BYTE;
        }
        currentValue = currentValue.accumulate(message);
    }

    public void log(CharMessage message) {
        if (!currentState.equals(CHAR)) {
            flush(message);
            currentState = CHAR;
        }
        currentValue = currentValue.accumulate(message);
    }

    public void log(BooleanMessage message) {
        flush(message);
        currentState = BOOL;
        currentValue = new BooleanMessage((boolean) message.getValue());
    }

    public void log(ObjectMessage message) {
        flush(message);
        currentState = OBJ;
        currentValue = new ObjectMessage(message.getValue());
    }

    public void log(IntArrayMessage message) {
        flush(message);
        currentState = INT_ARRAY;
        currentValue = new IntArrayMessage((int[]) message.getValue());
    }

    public void log(IntArrayMatrixMessage message) {
        flush(message);
        currentState = INT_MATRIX;
        currentValue = new IntArrayMatrixMessage((int[][]) message.getValue());
    }

    public void flush() {
        printer.print(currentValue.toString());
        currentValue = currentValue.getDefaultMessage();
        currentState = NONE;
    }

    public void flush(Message message) {
        if (!(currentState == NONE)) {
            printer.print(currentValue.toString());
        }
        currentValue = message.getDefaultMessage();
        currentState = NONE;
    }





}
