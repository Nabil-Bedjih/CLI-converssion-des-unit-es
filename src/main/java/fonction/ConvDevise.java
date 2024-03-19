package fonction;

import fr.api.ApiConnector;
import fr.api.ApiResponse;
import fr.api.Conversion;
import fr.api.Result;

import java.util.ArrayList;
import java.util.List;

public class ConvDevise {

    public static List<Double> convertirDevise(String deviseOrigine, String deviseDestination, List<Double> valeurs) {
        // Obtenir les taux de conversion entre les devises
        ApiConnector apiConnector = new ApiConnector();
        ApiResponse apiResponse = apiConnector.getcuurencyFromApi(deviseOrigine);

        // Vérifier si la réponse de l'API est valide
        if (apiResponse != null && apiResponse.getStatus().equals("success")) {
            // Obtenir les conversions de l'objet Result
            Result result = apiResponse.getResult();
            if (result != null) {
                // Rechercher la conversion correspondante dans la liste
                List<Conversion> conversions = result.getConversion();
                double tauxConversion = -1; // Initialiser à une valeur non valide
                for (Conversion conversion : conversions) {
                    if (conversion.getTo().equals(deviseDestination)) {
                        tauxConversion = conversion.getRate();
                        break; // Sortir de la boucle une fois que la conversion est trouvée
                    }
                }
                if (tauxConversion != -1) { // Assurez-vous que le taux de conversion est valide
                    // Convertir les valeurs en utilisant le taux de conversion
                    List<Double> valeursConverties = new ArrayList<>();
                    for (Double valeur : valeurs) {
                        valeursConverties.add(valeur * tauxConversion);
                    }
                    return valeursConverties;
                } else {
                    System.out.println("Erreur: Taux de conversion pour la devise de destination non disponible.");
                    return null;
                }
            } else {
                System.out.println("Erreur: Aucun résultat trouvé dans la réponse de l'API.");
                return null;
            }
        } else {
            System.out.println("Erreur lors de la récupération des taux de conversion des devises.");
            return null;
        }
    }

    public static void main(String[] args) {
        String deviseOrigine = "EUR";
        String deviseDestination = "USD";

        List<Double> valeurs = new ArrayList<>();
        valeurs.add(10.0);
        valeurs.add(20.0);

        List<Double> valeursConverties = convertirDevise(deviseOrigine, deviseDestination, valeurs);

        if (valeursConverties != null) {
            System.out.println("Valeurs converties: " + valeursConverties);
        } else {
            System.out.println("Erreur lors de la conversion des devises.");
        }
    }
}
