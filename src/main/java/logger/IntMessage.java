package logger;

import static com.acme.dbo.txlog.FacadePrefixes.INT_PREFIX;

public class IntMessage implements Message{
    private final int message;
    public IntMessage(int message){
        this.message = message;
    }

    @Override
    public String toString(){
        return INT_PREFIX + Integer.toString(message);
    }
}
