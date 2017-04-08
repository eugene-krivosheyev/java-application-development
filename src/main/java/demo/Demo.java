package demo;

public class Demo {
    public static void main(String[] args) {
        Printer printer;

        printer = new Printer("HW!");
        printer.print();
    }
}

class Printer {
    private String message; //Introduce object state with field/property

    Printer(String message) {
        this.message = message;
    }

    public void print() {
        System.out.println(message);
    }
}
