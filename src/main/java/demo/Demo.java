package demo;

public class Demo {
    public static void main(String[] args) {
        Printer printer; //local, temp, stack, auto

        m();

        printer = new Printer();
        printer.print("HW!!");
    }

    private static void m() {
        System.out.println("hhh");
    }
}

class Printer {
    public void print(String message) {
        System.out.println(message);
    }
}
