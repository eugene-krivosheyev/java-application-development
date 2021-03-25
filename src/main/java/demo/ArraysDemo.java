package demo;

public class ArraysDemo {
    public static void main(String[] args) {
        int[] array = new int[f()];
        System.out.println(array[3]);
        System.out.println(array.length);
        System.out.println(array[10]);
//        array.length = 10;

        int[][][] cube = new int[2][3][4];
        cube[0] = new int[3][];
        cube[1] = new int[3][];

        cube[0][0] = new int[4];
        cube[0][0][0] = 5;

        int[][] matrix = new int[2][];
        matrix[0] = new int[3];
        matrix[1] = new int[2];

        int[][] literal = {{}, {1}, {1, 2}};
        doSmthWithArray(new int[] {1, 2});

        for (int current : array) {
            System.out.println(current);
        }
        array[0] = 1;

//        System.arraycopy();
    }

    private static void doSmthWithArray(int[] param) {

    }

    private static int f() {
        return 10;
    }
}
