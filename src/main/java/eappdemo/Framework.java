package eappdemo;

public class Framework {
    public static void main(String[] args) {
        //region DI Core
        //xml config | @Annotations
        AccountController controller = new AccountController(
                new AccountService(new AccountRepository())
        );
        //endregion

        //region Main loop: remoting - Spring MVC
        while (true) {
            // net + treading + HTTP -> servlet container (tomcat, jetty)
            //HTTP request -> custom application class: Spring MVC
            FindRequest request = getHttpRequest();
            controller.findAccountById(request);
            sendHttpResponse();
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
