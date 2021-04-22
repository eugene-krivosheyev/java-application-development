package demo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class ExceptionsDemo {
    /**
     * VM:
     * try {
     *     ExcDemo.main()
     * } catch(Throwable e) {
     *     e.printStackTrace();
     *     System.exit(-1);
     * }
     */
    public static void main(String[] args) {
        final Controller controller = new Controller(new Printer());
        try {
            controller.log("HW");
        } catch (Throwable e) {
            e.printStackTrace();
            //????
        }
        // -


        try (Connection conn = null) { //try-with-resources

        } catch (SQLException e) {

        } // finally: conn.close();
    }
}

class Controller {
    private Printer printer;

    Controller(Printer printer) {
        this.printer = printer;
    }

    public void log(String m) throws LogException {
        //.....
        Connection conn = null;
        try {
            //...
            conn = null; //= new ???();
            printer.print(m);
            conn.commit();
            //...
        } catch (PrintException e) {
            throw new LogException("", e);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {

                }
            }
        }
        // –
    }
}

class Printer {
    public void print(String m) throws PrintException {
        //....
        try {
            //.....
            systemIO();
            systemIO();
            systemIO();
            //....
        } catch (MechanicalException e) {
            throw new PrintException("print operation failed", e);
        }
        // –
    }

    private void systemIO() throws MechanicalException {
        //...
        throw new MechanicalException("error #13666");
        // –
    }
}

class LogException extends Exception {
    public LogException() {
    }

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

class MechanicalException extends Exception {
    public MechanicalException(String message) {
        super(message);
    }

    public MechanicalException(String message, Throwable cause) {
        super(message, cause);
    }
}