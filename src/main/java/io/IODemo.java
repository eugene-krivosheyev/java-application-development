package io;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

import static java.nio.file.Files.readAllLines;
import static java.nio.file.Paths.get;

public class IODemo {
    public static void main(String[] args) {

        List<String> cats = new ArrayList<>();
//        cats.

        try {
//            new BufferedReader(
//                    new InputStreamReader(
//                            new BufferedInputStream(System.in)

//            new Scanner(System.in).nextLine()

            //java.io.File == java.nio.Path
            List<String> lines = readAllLines(get("target","file.txt"));
            Files.lines(get("file.txt"))
                    .map(String::toUpperCase)
                    .filter(s -> s.length() < 5)
                .forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();e.printStackTrace();
        }
    }
}
