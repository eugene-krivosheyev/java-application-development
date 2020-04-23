package exceptionsdemo;

public class LController {
    private final ISaver saver = new LSaver();

    public void log(String message) throws LogException {
        try {
            //..
            saver.save(message);
            //...
        } catch (SaveException | ArithmeticException e) {
            throw new LogException("Can't save " + message, e);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
