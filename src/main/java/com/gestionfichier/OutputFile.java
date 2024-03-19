package com.gestionfichier;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class OutputFile {
    public static void writeValuesToCSV(String filename, List<List<Double>> values) throws Exception {
        if (filename == null || filename.isEmpty()) {
            throw new Exception("Filename cannot be empty.");
        }

        if (values == null || values.isEmpty() || values.getFirst().isEmpty()) {
            throw new Exception("No values provided.");
        }

        try {
            FileWriter fileWriter = new FileWriter(filename, true);

            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            int numCols = values.getFirst().size();

            // Write values to the file
            for (int col = 0; col < numCols; col++) {
                for (int row = 0; row < values.size(); row++) {
                    bufferedWriter.write(Double.toString(values.get(row).get(col)));

                    if (row < values.size() - 1) {
                        bufferedWriter.write(";");
                    }
                }
                bufferedWriter.newLine();
            }

            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred while creating the file: " + e.getMessage());
        }
    }

    public static void createOutputFile(String filename, List<String> unit) {
        if (filename == null || filename.isEmpty()) {
            System.out.println("Filename cannot be empty.");
            return;
        }

        if (unit == null || unit.isEmpty()) {
            System.out.println("No units provided.");
            return;
        }

        try {
            FileWriter fileWriter = new FileWriter(filename);

            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            for (int i = 0; i < unit.size(); i++) {
                bufferedWriter.write(unit.get(i));

                if (i < unit.size() - 1) {
                    bufferedWriter.write(";");
                }
            }
            bufferedWriter.newLine();

            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred while creating the file: " + e.getMessage());
        }
    }

}
