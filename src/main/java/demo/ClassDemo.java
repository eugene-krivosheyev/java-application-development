package demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

import static demo.ClassDemo.incrementCount;
import static java.lang.Math.*;

/**
 * JCSC
 */
class ClassDemo {
    //st fild
    //inst fi
    //con
    //sm
    //pubimeth

    static {
        System.out.println("2");
//        fileConfigRead();
        classInstanceCount = 4;
        MY_CONST = 0;
    }

    public ClassDemo(int my) {
        System.out.println(MY_CONST);
    }

    public static final int MY_CONST;
    public static int classInstanceCount;

    public static int incrementCount(int step) {
        int localVar = 0; //stack
        System.out.println(localVar);
        classInstanceCount += step;
        return 0;
    }

    static {
        System.out.println("3");
    }
}

class Application {
    //
    public static void main(String[] args) {
        incrementCount(2);

        final double result = sin(1) + sqrt(10) * random() * PI;
    }
}
