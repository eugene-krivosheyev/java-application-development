package exceptionsdemo;

public interface ISaver {
    void save(String message) throws SaveException;
}
