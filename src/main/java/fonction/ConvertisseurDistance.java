package fonction;

import java.util.ArrayList;
import java.util.List;

public class ConvertisseurDistance {
    public static List<List<Double>> convertir(String uniteDepart, List<String> unitesArrivee, List<Double> valeurs) {
        List<List<Double>> resultat = new ArrayList<>();
        for (String uniteArrivee : unitesArrivee) {
            List<Double> conversions = new ArrayList<>();
            for (Double valeur : valeurs) {
                double resultatConversion = convertirSingle(uniteDepart, uniteArrivee, valeur);
                conversions.add(resultatConversion);
            }
            resultat.add(conversions);
        }
        return resultat;
    }

    private static double convertirSingle(String uniteDepart, String uniteArrivee, double valeur) {
        if ("mètres".equals(uniteDepart)) {
            if ("kilomètres".equals(uniteArrivee)) {
                return valeur / 1000;
            } else if ("centimètres".equals(uniteArrivee)) {
                return valeur * 100;
            } else if ("millimètres".equals(uniteArrivee)) {
                return valeur * 1000;
            } else if ("pouces".equals(uniteArrivee)) {
                return valeur * 39.3701;
            } else if ("pieds".equals(uniteArrivee)) {
                return valeur * 3.28084;
            } else if ("miles".equals(uniteArrivee)) {
                return valeur * 0.000621371;
            }
        } else if ("kilomètres".equals(uniteDepart)) {
            if ("mètres".equals(uniteArrivee)) {
                return valeur * 1000;
            } else if ("centimètres".equals(uniteArrivee)) {
                return valeur * 100000;
            } else if ("millimètres".equals(uniteArrivee)) {
                return valeur * 1000000;
            } else if ("pouces".equals(uniteArrivee)) {
                return valeur * 39370.1;
            } else if ("pieds".equals(uniteArrivee)) {
                return valeur * 3280.84;
            } else if ("miles".equals(uniteArrivee)) {
                return valeur * 0.621371;
            }
        } else if ("centimètres".equals(uniteDepart)) {
            if ("mètres".equals(uniteArrivee)) {
                return valeur / 100;
            } else if ("kilomètres".equals(uniteArrivee)) {
                return valeur / 100000;
            } else if ("millimètres".equals(uniteArrivee)) {
                return valeur * 10;
            } else if ("pouces".equals(uniteArrivee)) {
                return valeur * 0.393701;
            } else if ("pieds".equals(uniteArrivee)) {
                return valeur * 0.0328084;
            } else if ("miles".equals(uniteArrivee)) {
                return valeur * 0.00000621371;
            }
        } else if ("millimètres".equals(uniteDepart)) {
            if ("mètres".equals(uniteArrivee)) {
                return valeur / 1000;
            } else if ("kilomètres".equals(uniteArrivee)) {
                return valeur / 1000000;
            } else if ("centimètres".equals(uniteArrivee)) {
                return valeur / 10;
            } else if ("pouces".equals(uniteArrivee)) {
                return valeur * 0.0393701;
            } else if ("pieds".equals(uniteArrivee)) {
                return valeur * 0.00328084;
            } else if ("miles".equals(uniteArrivee)) {
                return valeur * 0.000000621371;
            }
        } else if ("pouces".equals(uniteDepart)) {
            if ("mètres".equals(uniteArrivee)) {
                return valeur * 0.0254;
            } else if ("kilomètres".equals(uniteArrivee)) {
                return valeur * 0.0000254;
            } else if ("centimètres".equals(uniteArrivee)) {
                return valeur * 2.54;
            } else if ("millimètres".equals(uniteArrivee)) {
                return valeur * 25.4;
            } else if ("pieds".equals(uniteArrivee)) {
                return valeur * 0.0833333;
            } else if ("miles".equals(uniteArrivee)) {
                return valeur * 0.000015783;
            }
        } else if ("pieds".equals(uniteDepart)) {
            if ("mètres".equals(uniteArrivee)) {
                return valeur * 0.3048;
            } else if ("kilomètres".equals(uniteArrivee)) {
                return valeur * 0.0003048;
            } else if ("centimètres".equals(uniteArrivee)) {
                return valeur * 30.48;
            } else if ("millimètres".equals(uniteArrivee)) {
                return valeur * 304.8;
            } else if ("pouces".equals(uniteArrivee)) {
                return valeur * 12;
            } else if ("miles".equals(uniteArrivee)) {
                return valeur * 0.000189394;
            }
        } else if ("miles".equals(uniteDepart)) {
            if ("mètres".equals(uniteArrivee)) {
                return valeur * 1609.34;
            } else if ("kilomètres".equals(uniteArrivee)) {
                return valeur * 1.60934;
            } else if ("centimètres".equals(uniteArrivee)) {
                return valeur * 160934;
            } else if ("millimètres".equals(uniteArrivee)) {
                return valeur * 1609340;
            } else if ("pouces".equals(uniteArrivee)) {
                return valeur * 63360;
            } else if ("pieds".equals(uniteArrivee)) {
                return valeur * 5280;
            }
        }
        throw new IllegalArgumentException("Conversion non supportée");
    }

    private static void afficherResultat(double valeur, String uniteArrivee, double resultat) {
        System.out.println(resultat);
    }
}