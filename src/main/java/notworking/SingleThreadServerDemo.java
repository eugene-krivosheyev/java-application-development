package notworking;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class SingleThreadServerDemo {
    public static void main(String[] args) throws IOException {
        try (ServerSocket connectionListener = new ServerSocket(9999)) {
            Socket clientConnection = connectionListener.accept();

            try (final BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                        new BufferedInputStream(
                            clientConnection.getInputStream())))) {

                final String readFromClient = in.readLine();
                System.out.println("Read from client " + clientConnection.getInetAddress() + ": " + readFromClient);
            }
        }
    }
}
