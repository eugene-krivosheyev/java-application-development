package com.acme.dbo.txlog.command;

public class MatrixCommand implements LogCommand {
    private int[][] message;
    LogType type = LogType.MATRIX;

    public MatrixCommand(int[][] message) {
        this.message = message;
    }

    @Override
    public String getValue() {
        return convertArrayToString(message);
    }

    @Override
    public LogType getType() {
        return type;
    }

    @Override
    public String getPrefix() {
        return type.getPrefix();
    }

    private String convertArrayToString(int[] array) {
        StringBuilder value = new StringBuilder("{");
        for (int i : array) value.append(i).append(", ");
        value.delete(value.length() - 2, value.length()).append("}");
        return value.toString();
    }

    private String convertArrayToString(int[][] array2) {
        StringBuilder value = new StringBuilder("{" + System.lineSeparator());
        for (int[] array : array2) value.append(convertArrayToString(array)).append(System.lineSeparator());
        value.delete(value.length() - 2, value.length()).append(System.lineSeparator()).append("}");
        return value.toString();
    }
}
