package exceptionsdemo;

import java.sql.SQLException;

public class LController {
    private final ISaver saver = new LSaver();

    public void log(String message) throws LogException {
        Connection conn = null;
        LogException logException = null;
        try {
            conn = ???;
            //..
            saver.save(message);
            //...
        } catch (SaveException | ArithmeticException e) {
            logException = new LogException("Can't save " + message, e);
            throw logException;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    if (logException != null) {
                        e.addSuppressed(logException);
                    }
                    throw e;
                }
        }
    }
}
