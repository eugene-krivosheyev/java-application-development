package exceptionsdemo;

import java.sql.SQLException;

public class LController {
    public void log(String message) throws LogException {
        try(ISaver saver = new LSaver()) {
            //..
            saver.save(message);
            //...
        } catch (SaveException | ArithmeticException e) {
            throw new LogException("Can't save " + message, e);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
