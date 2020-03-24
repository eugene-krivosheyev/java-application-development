package demo;

public class CodeReuseDemo {
    private static Byte byteAccumulator;
    private static Integer intAccumulator;

    public static void main(String[] args) {
        logByteAccums();
    }

    private static void logNumberAccums(Number accumulator, Runnable todo) {
        if (accumulator != null) {
            logPrimitive(accumulator);
            todo.run();
        }
    }

    private static void logByteAccums() {
        logNumberAccums(byteAccumulator, () -> byteAccumulator = null);
    }

    private static void logIntAccums() {
        logNumberAccums(intAccumulator, () -> intAccumulator = null);
    }

    private static void logPrimitive(Number intAccumulator) {

    }
}
