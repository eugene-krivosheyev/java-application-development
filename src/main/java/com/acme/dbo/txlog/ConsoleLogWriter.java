package com.acme.dbo.txlog;

class ConsoleLogWriter {

    void write(String message) {
        if (message != null) {
            System.out.println(message);
        }
    }
}
