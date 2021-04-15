package ooadrefactoring;


/**
 * 0. log algo +contr
 * 1. print to console +cpr
 * 2. decorating +mess
 * 3. accumulating +mess
 * 4. state management +contr
 * 5. --type overflow checking--
 *
 * Какие классы? (отвественность, состояние, поведение)
 * ЖЦ инстансов? Когда порождаются инстансы?
 */
public class LoggerFacade {
    private static AbstractController controller = new LoggerController(new ConsolePrinter());

    public static void log(String message) {
        controller.log(new StringMessage(message));
    }

    public static void log(int message) {
        controller.log(new IntMessage(message));
    }
}
