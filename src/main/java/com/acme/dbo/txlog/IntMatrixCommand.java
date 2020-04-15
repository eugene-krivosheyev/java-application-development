package com.acme.dbo.txlog;

import java.util.Arrays;

import static java.lang.System.lineSeparator;

public class IntMatrixCommand extends TemplateCommand {
    private int[][] message;

    public IntMatrixCommand(int[][] message) {
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

        return "primitives matrix: " + resultString;
    }

}
