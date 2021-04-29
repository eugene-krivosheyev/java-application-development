package eservice;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Stream;

public class Framework {
    public static void main(String[] args) {
        //region DI Framework: Spring Core
        AccountController controller = new AccountController(
                new AccountService(new AccountRepository())
        );
        //endregion

        //region Main Loop:
        final ExecutorService pool = Executors.newFixedThreadPool(100);
        while (waitForIncomingConnection()) {
            while (true) { //requests loop
                Request request = waitForIncomingRequest(); //servlet container: tomcat, jetty

                pool.execute( () -> sendResponse(controller.findAccountById(request.getId())));
            }
        }
        pool.shutdown();
        //endregion
    }

    public void testIO() {
        try {
            final List<String> strings = Files.readAllLines(Paths.get("text.txt"));
            final Stream<String> test2txt = Files.lines(Paths.get("test2txt"));

            Files.lines(Paths.get("test2txt"))
                    .map(s -> s)
                    .filter(s -> s.length() > 5)
                    .forEach(s -> System.out.println(s));

            //1. classic IO: blocking ops.
            //2. NIO2: native + async
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Request waitForIncomingRequest() {
        return null;
    }

    private static boolean waitForIncomingConnection() {
        return false;
    }

    private static void sendResponse(Account acc) {

    };
}
