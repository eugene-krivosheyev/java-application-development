package com.acme.dbo.txlog.writers;

public class WriteException extends Exception {
   public WriteException(String message){
      super(message);
   }
}
