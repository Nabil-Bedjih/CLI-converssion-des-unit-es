package org.example;

import com.gestionfichier.InputFile;
import com.gestionfichier.OutputFile;
import fonction.ConvTemperature;
import fonction.ConvertisseurDistance;
import fonction.VitesseConv;
import picocli.CommandLine;
import picocli.CommandLine.Command;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.example.Main.lireFichier;
import static org.example.Main.parseArg;


@Command(name = "convert", mixinStandardHelpOptions = true, version = "convert 1.0",
        description = "\nCommand allowing you to convert from to several units (distance, weight, currency, temperature, etc.)\n"
        ,header = "Command for unit converssion\n",optionListHeading = "Option are : \n")
public class Convert implements Runnable{
    @CommandLine.Option(names = {"-h", "--help"}, usageHelp = true)
    Boolean help;

    @CommandLine.Option(names = {"-du", "--distance"}, required = false, description = "distance unit\n")
    private String dunit;

    @CommandLine.Option(names = {"-vu", "--vitesse"}, required = false, description = "vitesse unit\n")
    private String vunit;

    @CommandLine.Option(names = {"-tu", "--temperature"}, required = false, description = "temperature unit\n")
    private String tunit;

    @CommandLine.Option(names = {"-v", "--value"}, required = false, description = "Value to convert\n")
    private String value;
    @CommandLine.Option(names = {"-f", "--file"},required = false, description = "Text file containing the input data\n")
    private File inputFile;

    @CommandLine.Option(names = {"-ou", "--outunit"}, required = false, description = "Output unit\n")
    private String listOfUnit;
    @CommandLine.Option(names = {"-of", "--outputunifFile"}, required = false, description = "Output unit file\n\n")
    private File otputUnitFile;


    public void run() {
        if (dunit != null){
            if (value != null){
            } else if (inputFile != null) {
                try {
                    List<List<Double>> values = new ArrayList<>();
                    List<Double> list = new ArrayList<>();
                    list = InputFile.getValueFromURL(String.valueOf(getClass().getResource("/test.txt")));
                    OutputFile.createOutputFile("outputfile.csv",Main.parseArg(listOfUnit));

                    values = ConvertisseurDistance.convertir(dunit,Main.parseArg(listOfUnit),list);
                    OutputFile.writeValuesToCSV("outputfile.csv", values);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }

            }
        }

        if (tunit != null){
            if (value != null){
            } else if (inputFile != null) {
                try {
                    List<List<Double>> values = new ArrayList<>();
                    List<Double> list = new ArrayList<>();
                    list = InputFile.getValueFromURL(String.valueOf(getClass().getResource("/test.txt")));
                    OutputFile.createOutputFile("outputfile.csv",Main.parseArg(listOfUnit));

                    values = ConvTemperature.convertir(tunit,Main.parseArg(listOfUnit),list);
                    OutputFile.writeValuesToCSV("outputfile.csv", values);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }

            }
        }
        if (vunit != null){
            if (value != null){
            } else if (inputFile != null) {
                try {
                    List<List<Double>> values = new ArrayList<>();
                    List<Double> list = new ArrayList<>();
                    list = InputFile.getValueFromURL(String.valueOf(getClass().getResource("/test.txt")));
                    OutputFile.createOutputFile("outputfile.csv",Main.parseArg(listOfUnit));

                    values = VitesseConv.convert(vunit,Main.parseArg(listOfUnit),list);
                    OutputFile.writeValuesToCSV("outputfile.csv", values);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }

            }
        }



/*
        if (tunit == null && value == null){
            System.out.printf("temperature unit indefined");
        }else{
            System.out.println("temperature unit :  "+ dunit);
            ConvertisseurTemperature.convertir(tunit,listOfUnit, Double.parseDouble(value));
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
        */
    }
}
