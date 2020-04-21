package exceptionsdemo;

import java.io.IOException;
import java.sql.SQLException;

public class LSaver implements ISaver {
    @Override
    public void save(String message)  throws SaveException {
        try {
            System.out.println(message);
            throw new IOException("cn't file");
        } catch (IOException | SQLException e) {
//            e.printStackTrace();|
            System.exit(0);
            throw new SaveException("file" + message, e);
            //....

        } catch (Exception e) {
            return;
        } finally {

        }
    }
}
