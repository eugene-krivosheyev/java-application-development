package demo;

public class CodeReuseDemo {
    private static Byte byteAccumulator;
    private static Integer intAccumulator;

    public static void main(String[] args) {
        logNumberAccums(intAccumulator);
    }

    private static void logNumberAccums(Number accumulator) {
        if (accumulator != null) {
            logPrimitive(accumulator);

            if (accumulator instanceof Byte) {
                byteAccumulator = null;
            } else if (accumulator instanceof Integer) {
                intAccumulator = null;
            }
        }
    }

    private static void logByteAccums() {
        logNumberAccums(byteAccumulator);
    }

    private static void logIntAccums() {
        logNumberAccums(intAccumulator);
    }

    private static void logPrimitive(Number intAccumulator) {

    }
}
