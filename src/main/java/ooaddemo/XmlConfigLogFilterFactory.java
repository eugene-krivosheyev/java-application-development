package ooaddemo;

public class XmlConfigLogFilterFactory {
    public static LogFilter create() {
        return new MessageLengthLogFilter(10);
    }
}
