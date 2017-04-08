package demo;

public class Demo {
    public static void main(String[] args) {
        Printer printer; //CNFE, OOME: (perm/meta space)

        printer = new Printer(); //OOME: (object space)
        printer.print("HW!!"); //SOFE
    }
}

class Printer {
    public void print(String message) {
        System.out.println(message);
    }
}
