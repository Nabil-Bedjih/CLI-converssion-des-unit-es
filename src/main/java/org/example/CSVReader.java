package org.example;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVReader {
    public static void readAndDisplayCSV(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Séparer les champs en utilisant le point-virgule comme délimiteur
                String[] fields = line.split(";");

                // Afficher chaque champ dans une colonne avec un espace de largeur fixe
                for (String field : fields) {
                    System.out.printf("%-20s", field); // Utilisation d'un espace de largeur fixe pour chaque colonne
                    System.out.print("| "); // Ajout d'une ligne de séparation entre les colonnes
                }
                System.out.println(); // Passer à la ligne suivante après avoir traité une ligne
                printDivider(fields.length); // Afficher une ligne de séparation entre chaque ligne du tableau
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Fonction pour imprimer une ligne de séparation entre chaque ligne du tableau
    private static void printDivider(int numColumns) {
        for (int i = 0; i < numColumns; i++) {
            System.out.print("--------------------+ "); // Utilisation de tirets comme séparateurs
        }
        System.out.println(); // Passer à la ligne suivante après avoir imprimé la ligne de séparation
    }
}


