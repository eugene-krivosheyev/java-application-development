package demo;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class EncapsulationDemo {
    public static void main(String[] args) {
//        Message message = new Message("hello", 0);
//        new Message("mesage 2");
//        new Girl();

//        coll.map(e -> new MyObj(e))

//        Message m = MessageFactory.create();
//        Arrays.asList(1,2,3);
//        Optional.empty();
//        Optional.of(1);
//        List.of(1,2,3);
//
//new Mess(..............)
//        new MessageBuilder()
//                .withConfigFile(xml)
//                .withSeverity();
    }
}

class Girl {
    private int age;

    public int getAge() {
        return 18;
    }
}

class Boy {
    private int beardSize;

    public int getBeardSize() {
        return beardSize * 5;
    }
}

//JavaBeans | POJO
//Domain Entity
class Message {
    private String message;
    private int severity;
    private String user;// = null;

    Message() {
        this(1); //this("def mess")
    }

    Message(int severity) {
       this("default message", severity);
    }

    Message(String message) {
        this(message, 1);
    }

    Message(String message, int severity) {
        this.setMessage(message);
        this.setSeverity(severity);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getSeverity() {
        if (severity > 5) throw new IllegalArgumentException("kgjhfdkgj");
        return severity;
    }

    public void setSeverity(int severity) {
        this.severity = severity;
    }
}