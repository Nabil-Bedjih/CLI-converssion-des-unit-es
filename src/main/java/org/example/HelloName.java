package org.example;

import picocli.CommandLine;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Command(name = "convert", mixinStandardHelpOptions = true, version = "convert 1.0",
        description = "unit conversion")
public class HelloName  implements Runnable{
    @CommandLine.Option(names = {"-u", "--unit"}, required = true, description = "unit")
    private String unit;

    @CommandLine.Option(names = {"-v", "--value"}, required = true, description = "Value to convert")
    private String value;

    @CommandLine.Option(names = {"-ou", "--outputunit"}, required = true, description = "Output value")
    private String outputvalue;

    public void run() {
        if (unit == null || unit.length()==0){
            System.out.printf("Bonjour");

        }else{
            System.out.println("unit :  "+ unit);
            System.out.println("value :  "+ value);
            System.out.printf("output value :  "+ outputvalue);
        }
    }
}
