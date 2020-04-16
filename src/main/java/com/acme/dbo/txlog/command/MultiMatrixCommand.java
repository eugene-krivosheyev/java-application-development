package com.acme.dbo.txlog.command;

public class MultiMatrixCommand implements LogCommand {
    private int[][][][] message;
    LogType type = LogType.MULTIMATRIX;

    public MultiMatrixCommand(int[][][][] message) {
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

    private String convertArrayToString(int[][][] array3) {
        StringBuilder value = new StringBuilder("{" + System.lineSeparator());
        for (int[][] array2 : array3) value.append(new MatrixCommand(array2).getValue()).append(System.lineSeparator());
        value.delete(value.length() - 2, value.length()).append(System.lineSeparator()).append("}");
        return value.toString();
    }

    private String convertArrayToString(int[][][][] array4) {
        StringBuilder value = new StringBuilder("{" + System.lineSeparator());
        for (int[][][] array3 : array4) value.append(convertArrayToString(array3)).append(System.lineSeparator());
        value.delete(value.length() - 2, value.length()).append(System.lineSeparator()).append("}");
        return value.toString();
    }
}
