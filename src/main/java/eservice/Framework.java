package eservice;

public class Framework {
    public static void main(String[] args) {
        //region DI Framework: Spring Core
        AccountController controller = new AccountController(
                new AccountService(new AccountRepository())
        );
        //endregion

        //region Main Loop:
        while (waitForIncomingConnection()) {
            while (true) { //requests loop
                Request request = waitForIncomingRequest(); //servlet container: tomcat, jetty
                switch (request.getOperation()) {
                    case "GET /account/{id}" : sendResponse(controller.findAccountById(request.getId()));
                }
            }
        }
        //endregion
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
