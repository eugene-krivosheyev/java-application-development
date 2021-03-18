package demo;

public class SwitchAndCycleDemo {
    public static void main(String[] args) {
        if (f1()) {

        } else if(f2()) {

        } else {

        }

        int age = 30;
        switch(age) {
            case 20: {
                System.out.println("молодой еще!");
                break;
            }
            case 30:
                System.out.println("уже норм"); break;
            case 40:
                System.out.println("уже поздно"); break;
        }

        switch (1) {
            default: break;
            case 2: break;
        }

    }

    private static boolean f2() {
        return false;
    }

    private static boolean f1() {
        return false;
    }

    private static void methodWithParam(int param) {
        if (param > 0) {
            // main flow
        } else if (param < 0) {
            throw new IllegalArgumentException("param must be positive");
        } else if (param < 0) {
            throw new IllegalArgumentException("param must be positive");
        }
    }

    // Guard Clauses
    private static void refactoredMethodWithParam(int param) {
        if (param <= 0) throw new IllegalArgumentException("param must be positive");
        if (param <= 0) throw new IllegalArgumentException("param must be positive");
        if (param <= 0) throw new IllegalArgumentException("param must be positive");

        // main flow
    }
}
