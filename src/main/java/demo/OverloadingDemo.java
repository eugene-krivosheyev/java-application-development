package demo;

public class OverloadingDemo {
    static void m(Object a) {
        System.out.println("1");
    }

    static void m(Integer b) {
        System.out.println("2");
    }

    public static void main(String[] args) {
        m(1);

        System.out.println();
        System.out.println(1 + 2 + "3" + 4); //ex, 10, 1234, _334_, 64
    }
}
