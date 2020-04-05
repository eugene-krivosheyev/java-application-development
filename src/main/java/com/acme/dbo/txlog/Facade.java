package com.acme.dbo.txlog;

import static com.acme.dbo.txlog.LoggerTypes.*;

public class Facade {

    private static LogController controller = new LogController();

    public static void log(int message) {
        controller.write(String.valueOf(message), INT_TYPE);
    }

    public static void log(byte message) {
        controller.write(String.valueOf(message), BYTE_TYPE);
    }

    public static void log(boolean message) {
        controller.write(String.valueOf(message), BOOLEAN_TYPE);
    }

    public static void log(Object message) {
        controller.write(String.valueOf(message), OBJECT_TYPE);
    }

    public static void log(char message) {
        controller.write(String.valueOf(message), CHAR_TYPE);
    }

    public static void log(String message) {
        controller.write(String.valueOf(message), STRING_TYPE);
    }

    public static void setDecorated(boolean isDecorated) {
        controller.setDecorated(isDecorated);
    }

    public static void flush() {
        controller.flush();
    }

    public static void clean() {
        controller.clean();
    }
}