package innernestedclassesdemo;


public class InnerClassesDemo {
    private static int globalVar;
    private int objectState;

    public static void main(String[] args) {
        int localVar = 17;
        DemoWriter writer = m -> m.toUpperCase(); //new ???
        writer.write("");

        new DemoLogger( message -> System.out.println(message));
        new DemoLogger(new DemoWriter() {
            @Override
            public void write(String message) {
                System.out.println(message);
            }
        });
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
