package demo;

public class CyclesDemo {
    public static void main(String[] args) {
        if (condition()) {
            System.out.println("111");
            System.out.println("111");
        } else if (condition2()) {

        } else {

        }

    }

    private static boolean condition2() {
        return false;
    }

    private static boolean condition() {
        return false;
    }

    private static void methodWithParam(int param) {
        if (param > 0) {
            // main flow
        } else if (param < 0) {
            throw new IllegalArgumentException("param must be positive");
        }
    }

    // Guard Clause
    private static void methodWithParam2(int param) {
        if (param <= 0) throw new IllegalArgumentException("param must be positive");
        if (param <= 0) throw new IllegalArgumentException("param must be positive");

        //mai flow
    }
}
