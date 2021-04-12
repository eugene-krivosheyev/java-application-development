package com.acme.dbo.txlog;

public class IntMatrixMessage {
    private final String MATRIX_PREFIX = "primitives matrix: ";
    private final String MATRIX_POSTFIX = "";

    private final int[][] message;

    public IntMatrixMessage(int[][] message) {
        this.message = message;
    }

    public int[][] getMessage() {
        return message;
    }

    public String getDecoratedMessage() {
        return MATRIX_PREFIX + matrixToString() + MATRIX_POSTFIX;
    }

    private String matrixToString() {
        StringBuilder result = new StringBuilder("{" + System.lineSeparator());
        for (int[] array : this.getMessage()) {
            result.append("{");
            for (int i = 0; i < array.length; i++) {
                result.append(array[i]);
                if (i<array.length-1){
                    result.append(", ");
                }
            }
            result.append("}"+ System.lineSeparator());
        }
        result.append("}");

        return result.toString();
    }
}
