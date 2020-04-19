package com.acme.dbo.txlog.message.processor.aggregation;

import com.acme.dbo.txlog.message.StringMessage;

public class RepeatingStringMessage extends StringMessage {

    private int count = 1;

    public RepeatingStringMessage(final String value) {
        super(value);
    }

    public RepeatingStringMessage(String value, int count) {
        super(value);
        this.count = count;
    }

    public int count(){
        return count;
    }

    @Override
    public String toString(){
        String countStr = "";
        if(count>1){
            countStr = " (x"+count+")";
        }
        return getValue()+countStr;
    }
}

