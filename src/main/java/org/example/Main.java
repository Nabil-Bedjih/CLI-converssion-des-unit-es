package org.example;


import picocli.CommandLine;

public class Main {
    public static void main(String[] args) {
         new CommandLine(new HelloName()).execute("-ou=m,km,c,cm,mm,dam");
    }
    public static String[] parseArg(String value) {
        return value.split(",");
    }
}
