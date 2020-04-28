package innernestedclassesdemo;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InnerClassesDemo {
    private static int globalVar;
    private int objectState;

    public static void main(String[] args) {
        int localVar = 17;
        DemoWriter writer = String::toUpperCase; //new ???
        writer.write("");

        new LlController(System.out::println);
        new DemoLogger( System.out::println );
        new DemoLogger(new DemoWriter() {
            @Override
            public void write(String message) {
                System.out.println(message);
            }
        });

        int context = 5;
        templateMethod(() -> Integer.toString(context));

        System.out.println("========================");
        List<Integer> cats = Arrays.asList(1,2,3,4,5);
        cats.parallelStream() //Stream API || CompletableFuture
                .map(e -> e + 1)
                .filter(e -> e <= 3)
            .forEach(System.out::println);


    }

    static ToDo templateMethod(ToDo todo) {
        //.....
        //.....
        System.out.println( todo.dodo() );
        //.....
        //.....
        return () -> "";
    }
}

@FunctionalInterface
interface ToDo {
    String dodo();
}

class LlController {
    public LlController(DemoWriter w) {
    }
}

@FunctionalInterface
interface DemoWriter {
    void write(String message);
}

class DemoLogger {
    public DemoLogger(DemoWriter writer) {

    }
}
