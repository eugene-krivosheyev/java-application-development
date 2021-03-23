package demo;

public class ArraysDemo {
    public static void main(String[] args) {
        int[] array = new int[f()];
        System.out.println(array[3]);
        System.out.println(array.length);
    }

    private static int f() {
        return 10;
    }
}
