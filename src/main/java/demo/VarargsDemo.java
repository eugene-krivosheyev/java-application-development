package demo;

public class VarargsDemo {
    public static void main(String... args) {
        m(new int[] {});
        m(new int[] {1});
        m(new int[] {1, 2});

        m();
        m(1);
        m(1, 2, 3);
    }

    private static void m(int... args) {
        for (int current : args) {
            System.out.println(current);
        }
    }
}
