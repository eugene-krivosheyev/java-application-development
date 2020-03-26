package ooaddemo;

public class LogWriter {
    private int writeMode;

    public LogWriter(int writeMode) {
        this.writeMode = writeMode;
    }

    public void write(String message) {
        switch (writeMode) {
            case 0: consoleWrite(message); break;
            case 1: fileWrite(message); break;
        }
    }

    private void fileWrite(String message) {

    }

    private void consoleWrite(String message) {
        System.out.println(message);
    }
}
