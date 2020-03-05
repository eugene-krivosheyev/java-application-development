package demo;

import java.lang.System;
import static demo.Façade.incrementCount;
import static demo.Façade.MY_CONST;
import static java.lang.Math.*;

public class Façade {
    static {
        System.out.println("static 1");
        MY_CONST = 0;
    }

    public static final int MY_CONST;
    public static int objectsCount = 0;

    public static int incrementCount(int step) {
        step = 1;
        int localVar = 0;
        java.lang.System.out.println(localVar);
        return 0;
    }

    static {
        System.out.println("static 2");
    }
}

class C2 {
}

class C1 {
    public static void main(String[] args) {
        //....
        //....
        //....
        //....
        //....
        random();

        final int factualStep = 0;
        incrementCount(factualStep); //side effect
        //????

        System.out.println(MY_CONST);
    }
}
