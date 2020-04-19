package com.acme.dbo.txlog.message;

public class IntArrayMessage extends MessageBase{

        private final int[] value;

        public IntArrayMessage(int[] value){
            this.value = value;
        }

        @Override
        public String toString(){
            return "";//Character.toString(value);
        }

}
