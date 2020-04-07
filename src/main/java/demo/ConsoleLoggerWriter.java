package demo;

import java.io.Serializable;

public class ConsoleLoggerWriter implements LogSaver, Serializable {
    @Override
    public void write(String message) {

    }

    public void newMethod() {}
}

class ConsSaver implements Saver {
    private Integer state;

    ConsSaver(Integer state) {
        this.state = state;
    }

    public void save()  { //????

    }

}

class FileSaver implements Saver {
    private String state;

    FileSaver(String state) {
        this.state = state;
    }

    public void save() {
    ///???
    }
}
}

interface Saver {
    public void save();
}

class Facade {
    public static void log(int mesage) {
        controller.log( new IntCommand(mesage) );
    }
}