package demo;

public class ArraysDemo {
    public static void main(String... args) {
        int[] intArray = new int[f()]; //MAX:2^31
        System.out.println(intArray.length);

        for (int current : intArray) {
            System.out.println(current);
        }

        System.out.println("> " + intArray[1]);
        System.out.println(intArray[2]);

        int[][] matrix = new int[2][];
        matrix[0] = new int[3];
        matrix[1] = new int[5];
        System.out.println( matrix[0][1] );

//        int[] literal = {1, 2, 3};
        doSmtWithArray( new int[] {1, 2, 3} );


        doSmthWithParam(new int[] {});
        doSmthWithParam(new int[] {1});
        doSmthWithParam(new int[] {1, 2});

        doSmthWithVararg(1);
        doSmthWithVararg(1, 2);
        doSmthWithVararg(1, 2, 3);
    }

    private static void doSmthWithVararg(int p, int... param) {
        System.out.println(param[0]);
        for (int current : param) {
            System.out.println(current);
        }
    }

    private static void doSmthWithParam(int[] param) {
        for (int current : param) {
            System.out.println(current);
        }
    }

    private static void doSmtWithArray(int[] param) {
        for (int current : param) {
            System.out.println(current);
        }
    }

    private static int f() {
        return 2;
    }
}
