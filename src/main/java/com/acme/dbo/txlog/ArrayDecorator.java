package com.acme.dbo.txlog;

import static java.lang.System.lineSeparator;

public class ArrayDecorator {

    //TODO list.stream().collect(Colectors.joining(“,”))

    public String arrayDecorate(int[] oneDimArray){
        StringBuilder aggregatedOneDimArray = new StringBuilder();
        aggregatedOneDimArray.append("{" );
        for (int oneDimArrayElement : oneDimArray) {
            aggregatedOneDimArray.append(oneDimArrayElement).append(", ");
        }
        aggregatedOneDimArray.deleteCharAt(aggregatedOneDimArray.length() - 1).deleteCharAt(aggregatedOneDimArray.length() - 1);
        aggregatedOneDimArray.append("}");
        return aggregatedOneDimArray.toString();
    }


    public String arrayDecorate(int[][] twoDimArray){
        StringBuilder aggregatedTwoDimArray = new StringBuilder();
        aggregatedTwoDimArray.append("{" + lineSeparator());
        for (int[] oneDimArray : twoDimArray) {
            aggregatedTwoDimArray.append(new ArrayDecorator().arrayDecorate(oneDimArray) + lineSeparator());
        }
        aggregatedTwoDimArray.append("}");
        return aggregatedTwoDimArray.toString();
    }
}
