package demo;

import java.util.function.Consumer;

public class FunctionalReuseDemo {
    private static Integer integerAccumulator;
    private static Byte byteAccumulator;

    public static void main(String[] args) {

    }

    public static void log(int message) {
        flushByteAccumulator();
//        handleAccumulator(message, integerAccumulator, () -> { integerAccumulator = message; });
    }

    public static void log(byte message) {
        flushIntAccumulator();
//        handleAccumulator(message, byteAccumulator,  () -> { byteAccumulator = message; });
    }

    private static void handleAccumulator(int message, Number checkAccumulator, Consumer<Integer> todo) {
        if (checkAccumulator == null) {
           todo.accept(message);
        } else {
            byteAccumulator = (byte)(byteAccumulator + message);
        }
    }

    private static void flushIntAccumulator() {
        System.out.println(integerAccumulator);
        integerAccumulator = null;
    }

    private static void flushByteAccumulator() {
        System.out.println(byteAccumulator);
        byteAccumulator = null;
    }
}
