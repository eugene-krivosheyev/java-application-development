package com.acme.dbo.txlog;

import java.util.Objects;

import static com.acme.dbo.txlog.LoggerTypes.*;

public class LogController {

    private boolean isDecorated;
    private LoggerTypes previousType;
    private String stringState = "";
    private int intState;
    private byte byteState;
    private int stringStateCount;


    public void write(String payLoad, LoggerTypes operationType) {
        checkBuffer(operationType);

        if (!operationType.isBuffered()) {
            System.out.println(decorate(payLoad, operationType));
        } else {
            accumulate(payLoad, operationType);
        }

        previousType = operationType;
    }

    public void flush() {
        switch (previousType) {
            case STRING_TYPE:
                stringState = decorate(stringState, STRING_TYPE);
                if (stringStateCount > 0) {
                    System.out.println(String.format("%s (x%d)", stringState, ++ stringStateCount));
                } else {
                    System.out.println(stringState);
                }
                stringStateCount = 0;
                stringState = "";
                break;
            case INT_TYPE:
                System.out.println(decorate(intState, INT_TYPE));
                intState = 0;
                break;
            case BYTE_TYPE:
                System.out.println(decorate(byteState, BYTE_TYPE));
                byteState = 0;
        }
    }

    private void checkBuffer(LoggerTypes newType) {
        if (Objects.isNull(previousType)) {
            previousType = newType;
        } else if (!newType.equals(previousType)) {
            flush();
        }
    }

    private void accumulate(String payLoad, LoggerTypes operationType) {
        switch (operationType) {
            case INT_TYPE:
                int intPayload = Integer.valueOf(payLoad);
                if (intPayload > Integer.MAX_VALUE - intState) {
                    flush();
                }
                intState += intPayload;
                break;
            case BYTE_TYPE:
                int bytePayload = Byte.valueOf(payLoad);
                if (bytePayload > Byte.MAX_VALUE - byteState) {
                    flush();
                }
                byteState += bytePayload;
                break;
            case STRING_TYPE:
                if (stringState.equals("")) {
                    stringState = payLoad;
                } else if (stringState.equals(payLoad)) {
                    stringStateCount++;
                } else {
                    flush();
                    stringState = payLoad;
                }
                break;
        }
    }

    private String decorate(Object payLoad, LoggerTypes type) {
        String stringPayLoad = String.valueOf(payLoad);
        if (isDecorated) {
            return type.getDecoratePrefix() + ": " + stringPayLoad;
        } else {
            return stringPayLoad;
        }
    }

    public void clean() {
        previousType = null;
    }

    public void setDecorated(boolean decorated) {
        isDecorated = decorated;
    }
}