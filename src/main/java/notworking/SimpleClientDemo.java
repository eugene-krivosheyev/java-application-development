package notworking;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class SimpleClientDemo {
    public static void main(String[] args) {
         try (Socket serverConnection = new Socket("localhost", 9999)) {

             try (PrintWriter out = new PrintWriter(
                     new OutputStreamWriter(
                             new BufferedOutputStream(
                                     serverConnection.getOutputStream())))) {

                out.println("превед сервер");
             }

         } catch (UnknownHostException e) {
             e.printStackTrace();
         } catch (IOException e) {
             e.printStackTrace();
         }
    }
}
