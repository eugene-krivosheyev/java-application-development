package com.acme.dbo.txlog.loggerFactory;

public class IntegerLogger implements Logger {

    private static int accum;


    public void log(int message) {
        if (message == 0 && accum == 0) {
            clearAccum(message);
        }
        else if (message == 0 && accum != 0) {
            clearAccum();
            clearAccum(message);
        }
        else {
            accumulation(message);
        }
    }

    private void accumulation(int message) {
        try {
            accum = Math.addExact(accum, message);
        }
        catch(ArithmeticException e) {
            clearAccum();
            log(message);
        }
    }

    public void clearAccum() {
        if (accum != 0) {
            clearAccum(accum);
            accum = 0;
        }
    }

    private void clearAccum(int message) {
        System.out.println("primitive: " + message);
    }
}
