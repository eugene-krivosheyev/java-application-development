package com.acme.dbo.txlog;


public class Facade {
    public static int counter = 0;


    /** Contract:
     * logs <b>ogogoggo!</b> message
     * @param message must be positive
     * @throws Exception
     * @see
     * @since 1.0
     */
//    @Contract(!null -> null, pure)
    public static void log(/* @NonNull */ int message) throws IllegalArgumentException {
        //assumeThatParamIsPosistive(message);

        if (message <= 0) throw new IllegalArgumentException();
        //~~implementation comment~~
        final String decoratedMessage = "primitive: " + message;
        printToConsole(decoratedMessage);
    }

    /*
    multi-line
     */
    public static void log(byte message) {
        printToConsole("primitive: " + message);
    }


    private static void printToConsole(String decoratedMessage) {
        System.out.println(decoratedMessage);
    }
}
