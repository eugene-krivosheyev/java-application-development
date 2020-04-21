package com.acme.dbo.txlog.message;

public class MatrixMessage extends MessageBase{

    private final int[][] value;

    public MatrixMessage(int[][] value){
        this.value = value;
    }
    
    @Override
    public String toString(){

        int bufferLength = 20 * value.length;
        if (value.length != 0 && bufferLength <= 0){
            bufferLength = Integer.MAX_VALUE;
        }

        StringBuilder buffer = new StringBuilder(bufferLength);
        buffer.append("{").append(System.lineSeparator());
        for (int[] row : value){
            buffer.append("{").append(arrayToString(row)).append("}").append(System.lineSeparator());
        }
        buffer.append("}");

        return  buffer.toString();
    }
}
