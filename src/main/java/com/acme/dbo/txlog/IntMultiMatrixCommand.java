package com.acme.dbo.txlog;

import java.util.Arrays;

import static java.lang.System.lineSeparator;

public class IntMultiMatrixCommand extends TemplateCommand {
    private int[][][][] message;

    public IntMultiMatrixCommand(int[][][][] message) {
        this.message = message;
    }

    @Override
    public String toString() {
        String resultString = Arrays.deepToString(message)
                .replace("[", "{")
                .replace("]", "}")
                .replace("}, {", "}" + lineSeparator() + "{");

        while (resultString.contains("{{") || resultString.contains("}}")) {
            resultString = resultString.replace("{{", "{" + lineSeparator() + "{")
                    .replace("}}", "}" + lineSeparator() + "}");
        }

        resultString = resultString.replaceAll("\\{(\\d+)}", "{" + lineSeparator() + "$1" + lineSeparator() + "}");
        return "primitives multimatrix: " + resultString;
    }
}
