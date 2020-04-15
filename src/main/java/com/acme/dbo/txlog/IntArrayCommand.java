package com.acme.dbo.txlog;

import java.util.Arrays;

public class IntArrayCommand extends TemplateCommand {
    private int[] message;

    public IntArrayCommand(int[] message) {
        this.message = message;
    }

    @Override
    public String toString() {

        String resultString = Arrays.toString(message)
                .replace("[", "{")
                .replace("]", "}");
        return "primitives array: " + resultString;
    }

}
