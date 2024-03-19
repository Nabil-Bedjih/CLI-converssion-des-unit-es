package fonction;

import java.util.ArrayList;
import java.util.List;

public class ConvTemperature {
    public static List<List<Double>> convertir(String uniteDepart, List<String> unitesArrivee, List<Double> valeurs) {
        List<List<Double>> resultats = new ArrayList<>();

        for (String uniteArrivee : unitesArrivee) {
            List<Double> valeursConverties = new ArrayList<>();
            for (Double valeur : valeurs) {
                double resultat = convertirUneUnite(uniteDepart, uniteArrivee, valeur);
                valeursConverties.add(resultat);
            }
            resultats.add(valeursConverties);
        }

        return resultats;
    }

    private static double convertirUneUnite(String uniteDepart, String uniteArrivee, double valeur) {
        if ("celsius".equals(uniteDepart.toLowerCase())) {
            return convertirDeCelsius(uniteArrivee, valeur);
        } else if ("fahrenheit".equals(uniteDepart.toLowerCase())) {
            return convertirDeFahrenheit(uniteArrivee, valeur);
        } else if ("kelvin".equals(uniteDepart.toLowerCase())) {
            return convertirDeKelvin(uniteArrivee, valeur);
        } else {
            throw new IllegalArgumentException("Unité de départ non supportée pour la conversion de température.");
        }
    }

    private static double convertirDeCelsius(String uniteArrivee, double valeur) {
        if ("fahrenheit".equals(uniteArrivee.toLowerCase())) {
            return (valeur * 9 / 5) + 32;
        } else if ("kelvin".equals(uniteArrivee.toLowerCase())) {
            return valeur + 273.15;
        }
        throw new IllegalArgumentException("Unité cible non supportée.");
    }

    private static double convertirDeFahrenheit(String uniteArrivee, double valeur) {
        if ("celsius".equals(uniteArrivee.toLowerCase())) {
            return (valeur - 32) * 5 / 9;
        } else if ("kelvin".equals(uniteArrivee.toLowerCase())) {
            return (valeur - 32) * 5 / 9 + 273.15;
        }
        throw new IllegalArgumentException("Unité cible non supportée.");
    }

    private static double convertirDeKelvin(String uniteArrivee, double valeur) {
        if ("celsius".equals(uniteArrivee.toLowerCase())) {
            return valeur - 273.15;
        } else if ("fahrenheit".equals(uniteArrivee.toLowerCase())) {
            return (valeur - 273.15) * 9 / 5 + 32;
        }
        throw new IllegalArgumentException("Unité cible non supportée.");
    }

    public static void main(String[] args) {
        String uniteDepart = "celsius";
        List<String> unitesArrivee = new ArrayList<>();
        unitesArrivee.add("fahrenheit");
        unitesArrivee.add("kelvin");

        List<Double> valeurs = new ArrayList<>();
        valeurs.add(100.0);
        valeurs.add(50.0);

        List<List<Double>> resultats = convertir(uniteDepart, unitesArrivee, valeurs);


        System.out.println(resultats);

    }
}