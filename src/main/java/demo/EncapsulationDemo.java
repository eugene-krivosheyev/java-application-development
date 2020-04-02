package demo;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EncapsulationDemo {
    public static void main(String[] args) {
        Message message1 = new Message("m", 0);
        Message message2 = new Message("m"); //[GRASP] Creator
        Message message3 = new Message(2);
        Message message4 = new Message();

        Message m = MessageFactory.create(); //FM

        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        List.of(1,2,3,4);
        Optional.empty();
        Optional.of(1);
        Collections.emptyList();
        Executors.newSingleThreadExecutor();
        Executors.cr


        AbstractFactory af = FactoryOfConcreteFactory.create();
        af.create();

        DocumentFactory.crate(DocType.PDF, Layout.Portrait, Colont.RIGHT, 1, );

        new DocBuilder()
                .withDocType(...)
                .withLayout(...)
                    .withAttach(new AttachBuilder()
                        .withPNG(..)
                        .withSize(...))
                .withColon()
            .build();

        new MyObj().m().m2().m3(); //Fluent interface for dot-driven programming


//        Date date = new DateDate();
//        date.setDay(35);
//        date.mo = -90;
//        date.year = -10_000_000;
    }
}

//JavaBeans | POJO
//Lombok
class Message {
    public static final int DEFAULT_SEVERITY = 0;
    public static final String DEFAULT_MESSAGE = "";

    private String message;
    private int severity;

    public Message(String message, int severity) {
        this.setMessage(message);
        this.setSeverity(severity);
        //.....
    }

    public Message(String message) {
        this(message, DEFAULT_SEVERITY);
    }

    public Message(int severity) {
        this(DEFAULT_MESSAGE, severity);
    }

    public Message() {
        this(DEFAULT_MESSAGE, DEFAULT_SEVERITY);
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getSeverity() {
        return severity;
    }

    public void setSeverity(int severity) {
        if (severity > 5) throw new IllegalArgumentException();
        this.severity = severity;
    }
}

class Date {
    int year;
    int mo;
    int day;
}

class Girl {
    public int getAge() {
        return 18;
    }
}

class Boy {
    private int beardSize;

    public int getBeardSize() {
        return beardSize * 3;
    }
}