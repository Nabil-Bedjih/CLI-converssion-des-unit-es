package org.example;

import picocli.CommandLine;
import picocli.CommandLine.Command;

import java.io.*;

import static org.example.Main.parseArg;


@Command(name = "convert", mixinStandardHelpOptions = true, version = "convert 1.0",
        description = "\nCommand allowing you to convert from to several units (distance, weight, currency, temperature, etc.)\n"
        ,header = "Command for unit converssion\n",optionListHeading = "Option are : \n")
public class HelloName  implements Runnable{
    @CommandLine.Option(names = {"-h", "--help"}, usageHelp = true)
    Boolean help;

    @CommandLine.Option(names = {"-du", "--distance"}, required = false, description = "distance unit\n")
    private String dunit;

    @CommandLine.Option(names = {"-wu", "--weight"}, required = false, description = "weight unit\n")
    private String wunit;


    @CommandLine.Option(names = {"-v", "--value"}, required = false, description = "Value to convert\n")
    private String value;
    @CommandLine.Option(names = {"-f", "--file"},required = false, description = "Text file containing the input data\n")
    private File inputFile;

    //@CommandLine.Option(names = {"-ou", "--outunit"}, required = false, description = "Output unit\n")
    //private String outputvalue;

    @CommandLine.Option(names = {"-ou", "--outunit"}, required = false, description = "Output unit\n")
    private String listOfUnit;
    @CommandLine.Option(names = {"-of", "--outputunifFile"}, required = false, description = "Output unit file\n\n")
    private File otputUnitFile;


    public void run() {
        if (dunit == null){
            System.out.printf("distence unit indefined");
        }else{
            System.out.println("distence unit :  "+ dunit);
        }

        if (wunit == null){
            System.out.printf("Weight unit indefined");
        }else{
            System.out.println("weight unit :  "+ dunit);
        }

        if (listOfUnit == null ) {
            System.out.printf("No output units specified");
        } else {
            String[] listOfOutUnit = parseArg(listOfUnit);
            System.out.println("Output units:");
            for (String unit : listOfOutUnit ) {
                System.out.println(unit);
            }
        }


    }
}
