package ooaddemo;

public class Main {
    public static void main(String[] args) {
        final Logger logger = new Logger(
                new FileLogWriter(), //Service | M.Fowler, E.Evance (DDD)
                new MessageLengthLogFilter(10)
        );

        //GoF
        //Design option 1: String|Int Command -> DTO equal [Dumb] Command := Anemic Domain Model
        //Design option 2: Str|Int Command -> Smart Command := Rich Domain Model
        logger.log(new StringCommand("any data 1"), 0);
        logger.log(new StringCommand("any data 2"), 1);
        logger.log(new StringCommand("any data 3"), 0);
        logger.log(new StringCommand("any data 4"), 2);
        logger.log(new IntCommand(4), 2);
        logger.log(new IntCommand(5), 2);

    }
}
