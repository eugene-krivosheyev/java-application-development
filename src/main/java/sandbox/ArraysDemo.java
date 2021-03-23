package sandbox;

public class ArraysDemo {
    public static void main(String[] args){
        int[] array = new int[fSize()];
        System.out.println(array[3]);
    }

    private static int fSize() {
        return 10;
    }
}
