package demo;

public class EnumDemo {
    public static void main(String[] args) {
        Color monitorColor = Color.GREEN;
        switch (monitorColor) {
            case GREEN: System.out.println();
        }

        Color[] values = Color.values();
        Color choosen = Color.valueOf("RED");

        String name = Color.GREEN.name();
        int ordinal = Color.GREEN.ordinal();

//        new Color(?????)
    }
}

enum Color {
    RED(10), GREEN(5), BLUE(1);

    private int pr;

    Color(int pr) {
        this.pr = pr;
    }

    public int getPr() {
        return pr;
    }

    public void myCustomLogic() {

    }
}

final class ClassColor {
    public static final ClassColor RED = new ClassColor("RED", 0, 10);
    public static final ClassColor GREEN = new ClassColor("GREEN", 1, 5);;
    public static final ClassColor BLUE = new ClassColor("BLUE", 2, 1);;

    //-.-.-.-.-

    private String name;
    private int ordinal;
    private int priority;

    private ClassColor(String name, int ordinal, int priority) {
        this.name = name;
        this.ordinal = ordinal;
        this.priority = priority;
    }

    public String name() {
        return name;
    }

    public int ordinal() {
        return ordinal;
    }

    public int getPriority() {
        return priority;
    }
}