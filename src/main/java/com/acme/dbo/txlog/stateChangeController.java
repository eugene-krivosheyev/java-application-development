package com.acme.dbo.txlog;

public interface stateChangeController {
    boolean checkIfStateSwithched(String previousState, String newState);
}
