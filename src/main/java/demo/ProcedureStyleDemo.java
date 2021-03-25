package demo;


public class ProcedureStyleDemo {
    public static void main(String[] args) {
        if (condition()) {
            m(0, Byte.MAX_VALUE);
        } else {
            m(0, Integer.MAX_VALUE);
        }
    }

    //region after
    private static void m(int param, int limit) {
        if (param >= limit) {
            //
        } else {
            //
        }
    }
    //endregion

    //region before
    private static void m1(int param) {
        if (param >= Byte.MAX_VALUE) {
            //
        } else {
            //
        }
    }

    private static void m2(int param) {
        if (param >= Integer.MAX_VALUE) {
            //
        } else {
            //
        }
    }
    //endregion


    private static boolean condition() {
        return false;
    }
}
