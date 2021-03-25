package demo;


public class ProcedureStyleDemo {
    public static void main(String[] args) {
        if (condition()) {
            m(0, Byte.MAX_VALUE, "option1");
        } else {
            m(0, Integer.MAX_VALUE, "option2");
        }
    }

    //region after
    private static void m(int param, int limit, String option) {
        if (param >= limit) {
            //op
        } else {
            switch (option) { //OCP
                case "option1": //op1(); break;
                case "option2": //op2(); break;
            }
        }
    }
    //endregion

    //region before
    private static void m1(int param) {
        if (param >= Byte.MAX_VALUE) {
            op();
        } else {
            //op1() --> OOP: Strategy, Template Method
        }
    }

    private static void m2(int param) {
        if (param >= Integer.MAX_VALUE) {
            op();
        } else {
            //op2() --> F: HOF
        }
    }
    //endregion

    //Refactoring: Extract Method, Sprout Method
    private static void op() {
        //op
    }

    private static boolean condition() {
        return false;
    }
}
