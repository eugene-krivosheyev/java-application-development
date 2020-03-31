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
    }
}

enum Color {
    RED, GREEN, BLUE
}