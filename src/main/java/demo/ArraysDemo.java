package demo;

public class ArraysDemo {
    public static void main(String[] args) {
        int[] intArray = new int[10];
        System.out.println( intArray.length );
        for (int current : intArray) {
            System.out.println(current);
        }

        int[][] matrix = new int[5][5]; matrix[0][0] = 1;
        int[][] gistogram = new int[3][];
        gistogram[0] = new int[00];
        gistogram[1] = new int[20];
        gistogram[2] = new int[20];

        int[] demo1 = {1,2,3};
        m(demo1);
        m(new int[] {1,2,3,4,5});

        int[][] m = {{1,2},{6,7,8}};
    }

    private static void m(int[] demo1) {
        System.out.println(">>>>>");
        for (int current : demo1) {
            System.out.println(current);
        }
        System.out.println("<<<<<");
    }
}
