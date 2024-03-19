package fonction;

import fr.api.ApiConnector;
import fr.api.ApiResponse;
import fr.api.Conversion;
import fr.api.Result;

import java.util.ArrayList;
import java.util.List;

public class ConvDevise {

    public static List<List<Double>> convertirDevise(String deviseOrigine, List<String> devisesDestinations, List<Double> valeurs) {
        ApiConnector apiConnector = new ApiConnector();
        ApiResponse apiResponse = apiConnector.getcuurencyFromApi(deviseOrigine);

        List<List<Double>> resultats = new ArrayList<>();

        if (apiResponse != null && apiResponse.getStatus().equals("success")) {
            Result result = apiResponse.getResult();
            if (result != null) {
                for (String deviseDestination : devisesDestinations) {
                    List<Conversion> conversions = result.getConversion();
                    double tauxConversion = trouverTauxConversion(conversions, deviseDestination);
                    if (tauxConversion != -1) {
                        List<Double> valeursConverties = convertirValeurs(valeurs, tauxConversion);
                        resultats.add(valeursConverties);
                    } else {
                        System.out.println("Erreur: Taux de conversion pour la devise de destination '" + deviseDestination + "' non disponible.");
                    }
                }
                return resultats;
            } else {
                System.out.println("Erreur: Aucun résultat trouvé dans la réponse de l'API.");
                return null;
            }
        } else {
            System.out.println("Erreur lors de la récupération des taux de conversion des devises.");
            return null;
        }
    }

    private static double trouverTauxConversion(List<Conversion> conversions, String deviseDestination) {
        for (Conversion conversion : conversions) {
            if (conversion.getTo().equals(deviseDestination)) {
                return conversion.getRate();
            }
        }
        return -1;
    }

    private static List<Double> convertirValeurs(List<Double> valeurs, double tauxConversion) {
        List<Double> valeursConverties = new ArrayList<>();
        for (Double valeur : valeurs) {
            valeursConverties.add(valeur * tauxConversion);
        }
        return valeursConverties;
    }
}
