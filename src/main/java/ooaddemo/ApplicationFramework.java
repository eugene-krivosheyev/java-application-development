package ooaddemo;

import ooaddemo.controller.Logger;
import ooaddemo.domain.SeverityLevel;
import ooaddemo.filter.SeverityMessageFilter;
import ooaddemo.domain.message.IntMessage;
import ooaddemo.domain.message.StringMessage;
import ooaddemo.printer.FileMessagePrinter;

import static ooaddemo.domain.SeverityLevel.ERROR;
import static ooaddemo.domain.SeverityLevel.WARNING;

public class ApplicationFramework {
    public static void main(String[] args) {
        //region DI framework
        final Logger logger = new Logger( // -> xml/json config
                new SeverityMessageFilter(ERROR),
                new FileMessagePrinter("out.log")
        );
        //endregion

        logger.log(new IntMessage(1), ERROR);
        logger.log(new StringMessage("str"), WARNING);
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
