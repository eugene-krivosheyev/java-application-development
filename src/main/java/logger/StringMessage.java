package logger;

import static com.acme.dbo.txlog.FacadePrefixes.STRING_PREFIX;

public class StringMessage implements Message{
    private final String message;
    public StringMessage(String message){
        this.message = message;
    }

    @Override
    public String toString(){
        return STRING_PREFIX + message;
    }    
}
