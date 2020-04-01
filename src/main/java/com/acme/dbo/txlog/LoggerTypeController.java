package com.acme.dbo.txlog;

public class LoggerTypeController {

    private Byte byteAccumulator;
    private Integer intAccumulator;
    private String stringAccumulator;
    private int stringCounter;

    public void log(Primitives type, Object message) {
        switch(type) {
            case INT:
                Integer intMessage = (Integer) message;
                if (intAccumulator != null && checkOverflow(intMessage + intAccumulator, intMessage, intAccumulator)) {
                    intAccumulator += intMessage;
                } else {
                    flush();
                    intAccumulator = intMessage;
                }
                break;
            case BYTE:
                Byte byteMessage = (Byte) message;

                if (byteAccumulator != null && checkOverflow((byte) (byteMessage + byteAccumulator), byteMessage, byteAccumulator)) {
                    byteAccumulator = (byte)(byteMessage+byteAccumulator);
                } else {
                    flush();
                    byteAccumulator = byteMessage;
                }
                break;
            case CHAR:
                flush();
                logPrint("char: " + message);
                break;
            case OBJECT:
                flush();
                logPrint("reference: " + message.toString());

                break;
            case STRING:
                String stringMessage = (String) message;
                if (stringAccumulator == null || !stringAccumulator.equals(stringMessage)) {
                    flush();
                    stringAccumulator = stringMessage;
                    stringCounter = 1;
                } else {
                    stringCounter++;
                }
                break;
            case BOOLEAN:
                flush();
                logPrint("primitive: " + message);
                break;
        }
    }

    public void flush() {
        if (stringAccumulator != null) {
            String message = stringAccumulator + (stringCounter > 1 ? (" (x" + stringCounter + ")") : "");
            logPrint("string: " + message);
            stringAccumulator = null;
        } else if (byteAccumulator != null) {
            logPrint("primitive: " + (byte) byteAccumulator);
            byteAccumulator = null;
        } else if (intAccumulator != null) {
            logPrint("primitive: " + (int) intAccumulator);
            intAccumulator = null;
        }
    }
    private void logPrint(String msg) {
        System.out.println(msg);
    }

    private boolean checkOverflow(int sum, int a, int b) {
        return (a > 0 && sum > b || a < 0 && sum < b);
    }

}