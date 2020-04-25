package com.acme.dbo.txlog;

import java.io.IOException;

class ConsoleLogWriter implements ILogWriter {

    public void write(String message) throws IOException {
        try {
            if (message != null) {
                System.out.println(message);
                if (message.contains("Abrakadabra")) {
                    System.out.println("Raising exception");
                    throw new IOException("Raised IOException!");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() {

    }
}
