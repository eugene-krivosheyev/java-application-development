package ooaddemo.printer;

import java.io.Serializable;

public class ConsolePrinter implements Printer, Serializable { //IS-A
    @Override // -> doc + check
    public void print(String message) {
        System.out.println(message);
    }
}
