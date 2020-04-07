package com.acme.dbo.txlog.command;

public class MultiMatrixCommand {
    private int[][][][] message;

    public MultiMatrixCommand(int[][][][] message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return convertArrayToString(message);
    }


    private String convertArrayToString(int[][][] array3) {
        StringBuilder value = new StringBuilder("{" + System.lineSeparator());
        for (int[][] array2 : array3) value.append(new MatrixCommand(array2).toString()).append(System.lineSeparator());
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
