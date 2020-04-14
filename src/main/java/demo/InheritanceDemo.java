package demo;

import java.io.IOError;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

public class InheritanceDemo {
    public static void main(String[] args) { //LSP
        EmptyMessageCheckLoggerWriter write = new ConsoleWriter();
        try {
            String result = write.write("HW!");
        } catch (IOException e) {
            //...
        }

//        System.out.println(result.toUpperCase());
        //1M sloc: result = String
        //result <-> ????
    }
}

interface LoggerWriter {
    public abstract void write(String message);
}

class EmptyMessageCheckLoggerWriter { // implements LoggerWriter {
    private String destination;

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

//    @Override
    String write(String message) throws IOException {
        if (message == null || message.equals("")) throw new IllegalArgumentException();
        return null;
    }
}

class ConsoleWriter extends EmptyMessageCheckLoggerWriter {
//    @Override
//    public String write(String message) throws CustomIOException {
//        super.write(message);
//        this.setDestination("filename");
//        System.out.println(message + " to destination: " + this.getDestination());
//    }
}
