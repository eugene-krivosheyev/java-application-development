package ooadrefactoring;

import java.io.Serializable;

public class ConsolePrinter implements Printer, Serializable { //IS-A
    @Override // -> for compiler: doc + check
    public void print(String body) {
        extracted(body);
    }

    public void extracted(String body) {
        System.out.println(body);
    }
}
