package com.acme.dbo.txlog.message;

public class IntArrayMatrixMessage {
    private final int[][] value;
    private final String DECORATION_PREFIX  = "primitives matrix: ";
    private final String DECORATION_POSTFIX = "";
    private static final String MATRIX_PREFIX = "{" + System.lineSeparator();
    private static final String MATRIX_POSTFIX = "}";


    public IntArrayMatrixMessage(int[][] value) {
        this.value = value;
    }

    public IntArrayMatrixMessage() {
        this(new int[][] {{0}});
    }

    public int[][] getValue() {
        return value;
    }

    @Override
    public String toString() {
        return DECORATION_PREFIX + matrixToString(value) + DECORATION_POSTFIX;
    }

    private String matrixToString(int[][] matrix) {
        StringBuilder buffer = new StringBuilder(MATRIX_PREFIX);
        for (int[] array: matrix) {
            IntArrayMessage temp = new IntArrayMessage(array);
            buffer.append(temp.toString(false)).append(System.lineSeparator());
        }
        return buffer.append(MATRIX_POSTFIX).toString();
    }

}
