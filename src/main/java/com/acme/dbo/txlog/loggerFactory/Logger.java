package com.acme.dbo.txlog.loggerFactory;

interface Logger<T> {

    public static <T> void log(T message) { }

    public static void clear() {}

}
