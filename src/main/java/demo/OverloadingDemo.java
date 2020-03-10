package demo;

import java.io.IOException;
import java.sql.SQLException;

public class OverloadingDemo {
    static void m(Integer a) {
        int lv;
    }

    static int m(Object b) {
        return 0;
    }

    static int m(String s) {
        return 0;
    }

    public static void main(String[] args) {
        m(1);
        System.out.println(1 + 2 + "3" + 4); //1234, 334, 73, 37
    }
}
