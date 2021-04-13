package com.acme.dbo.txlog.controller;

import com.acme.dbo.txlog.message.*;
import com.acme.dbo.txlog.printer.ConsolePrinter;
import static  com.acme.dbo.txlog.controller.AccumulatorState.*;


public class LoggerController {
    private AccumulatorState currentState = NONE;
    private StringMessage currentStringValue;
    private IntMessage currentIntValue;
    private ByteMessage currentByteValue;
    private CharMessage currentCharValue;
    private BooleanMessage currentBooleanValue;
    private ObjectMessage currentObjectValue;
    private IntArrayMessage currentIntArrayValue;
    private IntArrayMatrixMessage currentIntArrayMatrixValue;
    private ConsolePrinter consolePrinter;

    public LoggerController(ConsolePrinter printer) {
        this.consolePrinter = printer;
        this.currentStringValue = new StringMessage();
        this.currentIntValue = new IntMessage();
        this.currentByteValue = new ByteMessage();
        this.currentCharValue = new CharMessage();
        this.currentBooleanValue = new BooleanMessage();
        this.currentObjectValue = new ObjectMessage();
        this.currentIntArrayValue = new IntArrayMessage();
        this.currentIntArrayMatrixValue = new IntArrayMatrixMessage();
    }

    public void log(StringMessage message) {
        if (!(currentState.equals(STRING) & currentStringValue.isValueEqual(message))) {
            flush();
            currentState = STRING;
        }
        currentStringValue = currentStringValue.accumulate(message);
    }

    public void log(IntMessage message) {
        if (!currentState.equals(INT) | currentIntValue.isNumberOverflow(message)) {
            flush();
            currentState = INT;
        }
        currentIntValue = currentIntValue.accumulate(message);
    }

    public void log(ByteMessage message) {
        if (!currentState.equals(BYTE) | currentByteValue.isNumberOverflow(message)) {
            flush();
            currentState = BYTE;
        }
        currentByteValue = currentByteValue.accumulate(message);
    }

    public void log(CharMessage message) {
        if (!currentState.equals(CHAR)) {
            flush();
            currentState = CHAR;
        }
        currentCharValue = currentCharValue.accumulate(message);
    }

    public void log(BooleanMessage message) {
        flush();
        currentState = BOOL;
        currentBooleanValue = new BooleanMessage(message.getValue());
    }

    public void log(ObjectMessage message) {
        flush();
        currentState = OBJ;
        currentObjectValue = new ObjectMessage(message.getValue());
    }

    public void log(IntArrayMessage message) {
        flush();
        currentState = INT_ARRAY;
        currentIntArrayValue = new IntArrayMessage(message.getValue());
    }

    public void log(IntArrayMatrixMessage message) {
        flush();
        currentState = INT_MATRIX;
        currentIntArrayMatrixValue = new IntArrayMatrixMessage(message.getValue());
    }

    public void flush() {
        switch (currentState) {
            case INT: {
                consolePrinter.print(currentIntValue.toString());
                currentIntValue = new IntMessage();
                currentState = NONE;
                break;
            }
            case STRING: {
                consolePrinter.print(currentStringValue.toString());
                currentStringValue = new StringMessage();
                currentState = NONE;
                break;
            }
            case BYTE: {
                consolePrinter.print(currentByteValue.toString());
                currentByteValue = new ByteMessage();
                currentState = NONE;
                break;
            }
            case CHAR: {
                consolePrinter.print(currentCharValue.toString());
                currentCharValue = new CharMessage();
                currentState = NONE;
                break;
            }
            case BOOL: {
                consolePrinter.print(currentBooleanValue.toString());
                currentBooleanValue = new BooleanMessage();
                currentState = NONE;
                break;
            }

            case OBJ: {
                consolePrinter.print(currentObjectValue.toString());
                currentObjectValue = new ObjectMessage();
                currentState = NONE;
                break;
            }
            case INT_ARRAY: {
                consolePrinter.print(currentIntArrayValue.toString());
                currentIntArrayValue = new IntArrayMessage();
                currentState = NONE;
                break;
            }

            case INT_MATRIX: {
                consolePrinter.print(currentIntArrayMatrixValue.toString());
                currentIntArrayMatrixValue = new IntArrayMatrixMessage();
                currentState = NONE;
                break;
            }

            case NONE: {
                break;
            }
            default: {
                break;
            }
        }

    }



}
