package demo;

import static demo.MyColor.*;

public class EnumsDemo {
    public static void main(String[] args) {
        MyColor currentColor = MyColor.BLUE;
        switch (currentColor) {
            case RED:
        }
        MyColor.values();
        MyColor.valueOf("BLUE");
        RED.name(); //"RED"
        RED.ordinal(); //
        System.out.println(RED.ordinal());

        RED.getStr();
    }
}

enum MyColor {
    RED("11"), GREEN("22"), BLUE("33");

    //=============================

    private String str;

    MyColor(String str) {
        this.str = str;
    }


    public String getStr() {
        return str;
    }
}

final class MyMyColor {
    public static final MyMyColor RED = new MyMyColor("RED", 0, "11");
    public static final MyMyColor GREEN = new MyMyColor("GREEN", 1, "22");
    public static final MyMyColor BLUE = new MyMyColor("BLUE", 2, "33");

    //=================================================

    private String name;
    private int ordinal;
    private String str;

    MyMyColor(String name, int ordinal, String str) {
        this.name = name;
        this.ordinal = ordinal;
        this.str = str;
    }

    public String name() {
        return name;
    }

    public int ordinal() {
        return ordinal;
    }

    public String getDtr() {
        return str;
    }
}



