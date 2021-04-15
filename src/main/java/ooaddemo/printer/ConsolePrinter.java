package ooaddemo.printer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;

public class ConsolePrinter implements Printer, Serializable { //IS-A
    @Override // -> doc + check
    public void print(String message) {
        System.out.println(message);
//        if (1==1) throw new IOException();
    }
}
