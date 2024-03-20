package org.example;

import picocli.CommandLine;
import java.util.List;

public class Main {
    public static void main(String[] args) {
         new CommandLine(new Convert()).execute(args);
    }
    public static List<String> parseArg(String value) {
        return List.of(value.split(","));
    }
}
