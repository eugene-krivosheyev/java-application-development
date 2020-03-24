package demo;


public class ArraysDemo {
    public static void main(String[] args) {
        int[] array = new int[10];
        System.out.println(array.length);

        for (int current : array) {
            System.out.println(current);
        }

        System.out.println(array[9]); //?
//        System.out.println(array[-1]); //?

        int[][] matrix = new int[5][];
        matrix[0] = new int[2];
        matrix[1] = new int[3];
        matrix[2] = new int[4];
        System.out.println(matrix[0][1]);

        int[] hardCodedArray = {1, 2, 3, 4};
        int[][] hcMatrix = {{}, {1}, {1, 2}};

        my(new int[]{1, 2, 3});

        for (Object current : getObjectsFromDb()) {

        }

    }

    private static void my(int[] args) {
        for (int current : args) {
            System.out.println(current);
        }
    }

    private static Object[] getObjectsFromDb() {
        return new Object[]{};
    }

}