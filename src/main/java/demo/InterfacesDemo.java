package demo;

import java.io.Serializable;
import java.io.Writer;
import java.sql.Connection;

import static java.sql.Connection.*;

public class InterfacesDemo {
    public static void main(String[] args) {
        //Logger:
        LogWriter writer = new ConsoleLogWriter();
        writer.write("hw!!!");

        //Logger:
        Monitorable smth = writer;
        smth.getCurrentState();

        Serializable smth2 = writer;
        if (smth2 instanceof Serializable) {

        }


        System.out.println( writer instanceof ConsoleLogWriter);
        System.out.println( writer instanceof LogWriter);
        System.out.println( writer instanceof Monitorable);
        System.out.println( writer instanceof Serializable);

        int var = LogWriter.MY_VAR;
        Connection connection = null;
//        connection.setTransactionIsolation(TRANSACTION_NONE);
    }
}
interface Monitorable {
    String getCurrentState();
}
interface LogWriter extends Monitorable, Serializable {
    public static final int MY_VAR = 0;
    public void write(String message);
}

interface DbWriter {
    public void write(String message);
}

class ConsoleLogWriter implements LogWriter, DbWriter {
    /**
     *
     * @param message
     */
    @Override
    public void write(String message) {
        print(message);
    }

    /**
     *
     * @return
     */
    @Override
    public String getCurrentState() {
        return null;
    }

    private void print(String message) {
        System.out.println(message);
    }


}
