package exceptionsdemo;

public interface ISaver extends AutoCloseable {
    void save(String message) throws SaveException;
}
