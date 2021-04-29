package eappdemo;

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
        //region DI Core
        //xml config | @Annotations

        try {
            final List<String> strings = Files.readAllLines(Paths.get("file.txt"));
            final Stream<String> lines = Files.lines(Paths.get("file.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }


        AccountController controller = new AccountController(
                new AccountService(new AccountRepository())
        );
        //endregion

        //region Main loop: remoting - Spring MVC
        while (true) {
            // net + treading + HTTP -> servlet container (tomcat, jetty)
            //HTTP request -> custom application class: Spring MVC

            //waitForNetworkConnection()
            final ExecutorService pool = Executors.newFixedThreadPool(10);
            pool.execute(() -> {
                    while(true) {
                        FindRequest request = getHttpRequest();
                        controller.findAccountById(request);
                        sendHttpResponse();
                    }
            });
            pool.shutdown();
        }
        //endregion
    }

    /**
     * IO:
     * 1. bocking classic IO -> thread per request
     * 2. non-blocking IO: NIO2 - native + async
     */
    private static FindRequest getHttpRequest() {
        return new FindRequest();
    }

    private static void sendHttpResponse() {

    }
}
