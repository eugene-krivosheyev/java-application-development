package exceptionsdemo;

public class LController {
    private ISaver saver = new LSaver();

    public void log(String message) throws LogException {
        //.....
        try {
            //..
            saver.save(message);
            //...
        } catch (SaveException e) {
//            System.out.println(e.getMessage());
//            e.printStackTrace();
            throw new LogException("Can't save " + message, e);
        }
        //...
    }
}
