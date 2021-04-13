package ooadrefactoring;

/**
 *  polymorphism: "IS-A"
 */
public interface Printer {
    public static final int PIBLIC_STATIK_VOID = 1;
    public abstract void print(String body);

    static void newStaticMethod(String body) {
        System.out.println("kwdfjgksjfgjhfd");
    }

    default void newMethod() {
        this.print("");
    }
}
