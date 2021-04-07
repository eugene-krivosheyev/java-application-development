package com.acme.dbo.txlog;

public class ThresholdChecker {

    public boolean checkIfThresholdExceeded(int agggregatedBefore, byte nextElement) {
           if ((agggregatedBefore > 0 && nextElement > Byte.MAX_VALUE - agggregatedBefore) || (agggregatedBefore < 0 && nextElement < Byte.MIN_VALUE - agggregatedBefore)) {
            return true;
        } else return false;
    }

    ;

    public boolean checkIfThresholdExceeded(int agggregatedBefore, int nextElement) {
           if ((agggregatedBefore > 0 && nextElement > Integer.MAX_VALUE - agggregatedBefore) || (agggregatedBefore < 0 && nextElement < Integer.MIN_VALUE - agggregatedBefore)) {
            return true;
        } else return false;
    }

    ;
}
