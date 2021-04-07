package com.acme.dbo.txlog;

public class TypeChangeController {
    public boolean checkIfStateSwithched (String previousState, String newState){
        if (!newState.equals(previousState) && !(previousState.equals("NAN") || previousState.equals("INT[]") || previousState.equals("INT[][]"))) return true;
        else return false;
    }
}
