package demo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * try {
 *     main();
 * } catch (Throwable e) {
 *     ....
 *     e.printStackTrace();
 *     System.exit(-1);
 * }
 */
public class ExceptionsDemo {
    public static void main(String[] args) {
        final Controller controller = new Controller(new Printer());
        try {
            controller.log("HW!!");
        } catch (LogException e) {
            e.printStackTrace();
        }
        // -
    }
}

class Controller {
    private Printer printer;

    Controller(Printer printer) {
        this.printer = printer;
    }

    public void log(String message) throws LogException {
        try {
            //...
            printer.print(message);
            // -
        } catch (PrintException e) {
            //log
            throw new LogException("log didn't succeed for " + message, e);
        }
    }
}

class Printer {
    public void print(String message) throws PrintException {
        //....
        try (Connection conn = null) {
            //...
            systemLibWrite();
            // -
        } catch (SQLException | IOException e) {
            //log(e)
            throw new PrintException(message + " didn't print", e);
            // -
        }
        //....
    }

    private void systemLibWrite() throws IOException {
        //...
        throw new IOException("cant read file .sys");
        // -
        // -
    }
}

class LogException extends Exception {
    public LogException(String message) {
        super(message);
    }

    public LogException(String message, Throwable cause) {
        super(message, cause);
    }
}

class PrintException extends Exception {
    public PrintException(String message) {
        super(message);
    }

    public PrintException(String message, Throwable cause) {
        super(message, cause);
    }
}