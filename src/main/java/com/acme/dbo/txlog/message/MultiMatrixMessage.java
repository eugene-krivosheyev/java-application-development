package com.acme.dbo.txlog.message;

public class MultiMatrixMessage extends MessageBase{

    private final int[][][][] value;

    public MultiMatrixMessage(int[][][][] value){
        this.value = value;
    }
    
    @Override
    public String toString(){

        int bufferLength = 60 * value.length;
        if (value.length != 0 && bufferLength <= 0){
            bufferLength = Integer.MAX_VALUE;
        }

//        "primitives multimatrix: {" + System.lineSeparator() +
//                "{" + System.lineSeparator() +
//                "{" + System.lineSeparator() +
//                "{" + System.lineSeparator() +
//                "0" + System.lineSeparator() +
//                "}"+ System.lineSeparator()  +
//                "}" + System.lineSeparator() +
//                "}" + System.lineSeparator() +
//                "}" + System.lineSeparator()


        StringBuilder buffer = new StringBuilder(bufferLength);
        buffer.append("{").append(System.lineSeparator());
        for (int[][][] dim_1 : value){
            buffer.append("{").append(System.lineSeparator());
            for (int[][] dim_2 : dim_1) {
                buffer.append("{").append(System.lineSeparator());
                for (int[] dim_3 : dim_2) {
                    buffer.append("{").append(System.lineSeparator()).append(arrayToString(dim_3)).append(System.lineSeparator()).append("}").append(System.lineSeparator());
                }
                buffer.append("}").append(System.lineSeparator());
            }
            buffer.append("}").append(System.lineSeparator());
        }
        buffer.append("}");

        return  buffer.toString();
    }
}
