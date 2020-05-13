package io;

import java.io.*;

public class ClassicIODemo {
    public static void main(String[] args) {
        File file = new File("target/test.txt");
//        if (!file.canWrite()) throw new IllegalStateException();

        try (DataOutputStream out = new DataOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream(file)))) {

            out.writeUTF("Превед!!!");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        try (PrintWriter bufferedWriter = new PrintWriter(new FileWriter("target/test2.txt"))) {

            bufferedWriter.write("Пррреведддд!!!");
            bufferedWriter.println(1111);

        } catch (IOException e) {
            e.printStackTrace();
        }


        try (final BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(
                    new BufferedInputStream(
                        new FileInputStream("target/test3.txt")),
                    "windows-1251"))
        ) {

            String readLine;
            while((readLine = bufferedReader.readLine()) != null) {
                System.out.println(">>> " + readLine);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
