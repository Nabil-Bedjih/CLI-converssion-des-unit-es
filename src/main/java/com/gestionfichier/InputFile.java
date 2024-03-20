package com.gestionfichier;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class InputFile {

    public static List<Double> getValueFromURL(String fileURL) throws Exception {
        if (fileURL == null || fileURL.isEmpty()) {
            throw new Exception("File URL cannot be empty.");
        }
        List<Double> valuesList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new URL(fileURL).openStream()))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.isEmpty()) {
                    try {
                        double value = Double.parseDouble(line.replace(',', '.'));
                        valuesList.add(value);
                    } catch (NumberFormatException e) {
                        throw new InvalidDataFormatException("Invalid value in file: " + line + " the file should have only int or float number");
                    }
                }
            }
            return valuesList;
        } catch (IOException e) {
            throw new Exception("An error occurred while reading the file from URL: " + e.getMessage());
        }
    }

}
