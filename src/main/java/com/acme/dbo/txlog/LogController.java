package com.acme.dbo.txlog;

public class LogController {
    private final ConsolePrinter printer;

    private StringMessage lastStringMessage = null;
    private IntMessage lastIntMessage = null;
    private ByteMessage lastByteMessage = null;

    public LogController(ConsolePrinter printer) {
        this.printer = printer;
    }

    public void log(StringMessage stringMessage) {
        if (lastStringMessage != null) {
            if (stringMessage.messageEquals(lastStringMessage)) {
                lastStringMessage.incrementCounter();
            } else {
                flush();
                lastStringMessage = stringMessage;
            }
        } else {
            flush();
            lastStringMessage = stringMessage;
        }
    }

    public void log(IntMessage intMessage) {
        if (lastIntMessage != null) {
            if ((long) lastIntMessage.getMessage() + intMessage.getMessage() > Integer.MAX_VALUE) {
                flush();
                lastIntMessage = intMessage;
            } else {
                lastIntMessage = lastIntMessage.accumulate(intMessage);
            }
        } else {
            flush();
            lastIntMessage = intMessage;
        }
    }

    public void log(BooleanMessage booleanMessage) {
        flush();
        printer.print(booleanMessage.getDecoratedMessage());
    }

    public void log(ByteMessage byteMessage) {
        if (lastByteMessage != null) {
            if (lastByteMessage.getMessage() + byteMessage.getMessage() > Byte.MAX_VALUE) {
                flush();
                lastByteMessage = byteMessage;
            } else {
                lastByteMessage = lastByteMessage.accumulate(byteMessage);
            }
        } else {
            flush();
            lastByteMessage = byteMessage;
        }
    }

    public void log(IntArrayMessage intArrayMessage) {
        flush();
        for (int i : intArrayMessage.getMessage()) {
            log(new IntMessage(i));
        }
    }

    public void log(ObjectMessage objectMessage) {
        flush();
        printer.print(objectMessage.getDecoratedMessage());
    }

    public void log(StringArrayMessage stringArrayMessage) {
        for (String s : stringArrayMessage.getMessage()) {
            log(new StringMessage(s));
        }
    }

    public void log(CharMessage charMessage) {
        flush();
        printer.print(charMessage.getDecoratedMessage());
    }

    public void log(IntMatrixMessage intMatrixMessage) {
        flush();
        printer.print(intMatrixMessage.getDecoratedMessage());
    }

    public void flush() {
        if (lastIntMessage != null) {
            printer.print(lastIntMessage.getDecoratedMessage());
            lastIntMessage = null;
        } else if (lastByteMessage != null) {
            printer.print(lastByteMessage.getDecoratedMessage());
            lastByteMessage = null;
        } else if (lastStringMessage != null) {
            printer.print(lastStringMessage.getDecoratedMessage());
            lastStringMessage = null;
        }
    }
}
