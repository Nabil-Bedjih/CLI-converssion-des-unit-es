package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVReader {
    public static void readAndDisplayCSV(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(";");
                for (String field : fields) {
                    System.out.printf("%-20s", field);
                    System.out.print("| ");
                }
                System.out.println();
                printDivider(fields.length);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void printDivider(int numColumns) {
        for (int i = 0; i < numColumns; i++) {
            System.out.print("--------------------+ ");
        }
        System.out.println();
    }
}


