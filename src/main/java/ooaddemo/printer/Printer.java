package ooaddemo.printer;

public interface Printer {
    public static final int INTERFACE_CONST = 1;
    public abstract void print(String message);

    public static void commonMethod() {
        System.out.println("1111");
//        this.print();
    }

    default void instMethod() {
        this.toString();
    }
}
