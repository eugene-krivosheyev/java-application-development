package innernestedclassesdemo;


public class InnerClassesDemo {
    private static int globalVar;
    private int objectState;

    public static void main(String[] args) {
        int localVar = 17;

        new DemoLogger(new DemoWriter() {
            @Override
            public void write(String message) {

            }
        });
    }
}

interface DemoWriter {
    void write(String message);
}

class DemoLogger {
    public DemoLogger(DemoWriter writer) {

    }
}
