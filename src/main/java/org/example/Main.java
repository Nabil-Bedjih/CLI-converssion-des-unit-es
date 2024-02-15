package org.example;


import picocli.CommandLine;

public class Main {
    public static void main(String[] args) {
         new CommandLine(new HelloName()).execute("-u=m","-v=3","-ou=km");
    }
}