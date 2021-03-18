package demo;

import java.util.Objects;

public class CyclesDemo {
    public static void main(String[] args) {
        //region IF
        if (condition()) {
            System.out.println("111");
            System.out.println("111");
        } else if (condition2()) {

        } else {

        }
        //endregion

        //region Switch
        String var = null; // == .equals()
        switch (var) {
            case "1": {
                System.out.println("1"); break;
            }
            case "2":
                System.out.println("2"); break;
            default:
                System.out.println("something other"); break;
        }

        if ("1".equals(var)) {

        }
        if (Objects.equals("1", var)) {

        }
        //endregion

        //region Loops
        for(int counter = 0, j = 0; counter < 10; counter++, j++) {
            //....
        }

        do {

        } while (forever());

        while(forever()) {

        }

        //foreach
        for (String current : args) {
            System.out.println(current);
        }

        outer: while (forever()) {
            //...
            inner: do {
                if (condition()) break outer;
                if (condition()) continue outer;
                //...
                third: for (int i = 0; i < 10; i++) {
                    if (condition()) break; // -> 65
                    if (condition()) continue; // -> 60
                    //...
                }
                //...
            } while (forever());
            //...
        }
        //endregion
    }

    private static boolean forever() {
        return true;
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
