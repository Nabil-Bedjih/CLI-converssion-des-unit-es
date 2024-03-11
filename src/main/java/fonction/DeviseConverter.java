import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class DeviseConverter {

    public static double convert(String baseCurrency, String targetCurrency, double amount) throws IOException {
        String apiKey = "YOUR_API_KEY"; // Remplacez YOUR_API_KEY par votre clé API Fixer.io
        String apiUrl = "http://data.fixer.io/api/latest?access_key=" + apiKey + "&base=" + baseCurrency + "&symbols=" + targetCurrency;

        // Créer une connexion HTTP et récupérer les données JSON
        URL url = new URL(apiUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();

        // Lire la réponse JSON
        int responseCode = conn.getResponseCode();
        if (responseCode != 200) {
            throw new RuntimeException("Erreur HTTP: " + responseCode);
        } else {
            StringBuilder response = new StringBuilder();
            Scanner scanner = new Scanner(url.openStream());
            while (scanner.hasNext()) {
                response.append(scanner.nextLine());
            }
            scanner.close();

            // Extraire le taux de change du JSON
            String jsonResponse = response.toString();
            double exchangeRate = Double.parseDouble(jsonResponse.split("\"" + targetCurrency + "\":")[1].substring(1, 7));

            // Convertir la devise
            return amount * exchangeRate;
        }
    }

    public static void main(String[] args) {
        try {
            String baseCurrency = "EUR"; // Devise de base (par exemple, Euro)
            String targetCurrency = "USD"; // Devise cible (par exemple, Dollar américain)
            double amount = 100; // Montant à convertir

            double convertedAmount = convert(baseCurrency, targetCurrency, amount);
            System.out.println(amount + " " + baseCurrency + " = " + convertedAmount + " " + targetCurrency);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
