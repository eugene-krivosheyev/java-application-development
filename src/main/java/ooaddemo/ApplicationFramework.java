package ooaddemo;

public class ApplicationFramework {
    public static void main(String[] args) {
        //region DI framework
        final Logger logger = new Logger( // -> xml/json config
                new SeverityMessageFilter(1),
                new FileMessagePrinter("out.log")
        );
        //endregion

        logger.log(new IntMessage(1), 0);
        logger.log(new StringMessage("str"), 1);
        //region Request cycle
        /*
        while(true) {
            getHttpRequest();
            logger.log(....);
            sendHttpRespone();
        }
         */
        //endregion
    }
}
