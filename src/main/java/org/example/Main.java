package org.example;


import picocli.CommandLine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
         new CommandLine(new Convert()).execute("-cu=DZD","-ou=EUR,USD,BGN","-f=test.txt");
    }
    public static List<String> parseArg(String value) {
        return List.of(value.split(","));
    }

    public static ArrayList<Double> lireFichier(String urlFichier) {
        ArrayList<Double> valeurs = new ArrayList<>();

        try {
            URL url = new URL(urlFichier);
            BufferedReader lecteur = new BufferedReader(new InputStreamReader(url.openStream()));
            String ligne;

            // Lire chaque ligne du fichier
            while ((ligne = lecteur.readLine()) != null) {
                // Convertir la ligne en double et l'ajouter à l'ArrayList
                double valeur = Double.parseDouble(ligne);
                valeurs.add(valeur);
            }

            lecteur.close();
        } catch (IOException e) {
            System.err.println("Erreur lors de la lecture du fichier depuis l'URL : " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Erreur lors de la conversion de la ligne en double : " + e.getMessage());
        }

        return valeurs;
    }
}
