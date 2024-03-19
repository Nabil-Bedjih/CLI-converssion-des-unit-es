package fonction;

public class ConvertisseurTemperature {
    public static double convertir(String uniteDepart, String uniteArrivee, double valeur) {
        if ("celsius".equals(uniteDepart.toLowerCase())) {
            return convertirDeCelsius(uniteArrivee, valeur);
        } else if ("fahrenheit".equals(uniteDepart.toLowerCase())) {
            return convertirDeFahrenheit(uniteArrivee, valeur);
        } else if ("kelvin".equals(uniteDepart.toLowerCase())) {
            return convertirDeKelvin(uniteArrivee, valeur);
        }
        throw new IllegalArgumentException("Unité non supportée pour la conversion de température.");
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
}
