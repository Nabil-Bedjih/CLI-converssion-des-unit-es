package fr.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ApiConnector {
    ConfigReader configReader = new ConfigReader();
    String KEY;

    public ApiResponse getCurrencyFromApi(String cur) throws ApiException {
        try {
            KEY = configReader.readConfigFile(getClass().getResource("/config.txt"));
            String urlString = "https://api.devises.zone/v1/full/" + cur.toUpperCase() + "/json?key=" + KEY;
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            int status = connection.getResponseCode();
            System.out.println(status);

            if (status == 404) {
                throw new CurrencyNotFoundException("La devise n'a pas été trouvée. Veuillez vérifier la saisie.");
            } else if (status != 200) {
                throw new ApiException("Erreur lors de la récupération des données depuis l'API. Code d'état : " );
            }

            BufferedReader reader;
            String line;
            StringBuffer responseContent = new StringBuffer();

            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            while ((line = reader.readLine()) != null) {
                responseContent.append(line);
            }
            reader.close();

            ObjectMapper objectMapper = new ObjectMapper();
            ApiResponse apiResponse = objectMapper.readValue(responseContent.toString(), ApiResponse.class);

            System.out.println("Status: " + apiResponse.getStatus());

            connection.disconnect();
            return apiResponse;
        } catch (IOException e) {
            e.printStackTrace();
            throw new ApiException("Une erreur s'est produite lors de la communication avec l'API.");
        } catch (CurrencyNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Double> getRatesForElements(ApiResponse apiResponse, String[] tab) {
        List<Double> ratesList = new ArrayList<>();
        if (apiResponse != null && apiResponse.getResult() != null && apiResponse.getResult().getConversion() != null) {
            for (String element : tab) {
                for (fr.api.Conversion conversion : apiResponse.getResult().getConversion()) {
                    if (conversion.getTo().equals(element)) {
                        ratesList.add(conversion.getRate());
                    }
                }
            }
        }
        return ratesList;
    }

    public static void main(String[] args) throws ApiException {
        ApiConnector apiConnector = new ApiConnector();
        ApiResponse apiResponse = apiConnector.getCurrencyFromApi("DZD");

        String[] tab = {"USD", "EUR", "BGN"};
        List<Double> ratesList = getRatesForElements(apiResponse, tab);
        for (double rate : ratesList) {
            System.out.println("Rate : " + rate);
        }

        if (apiResponse != null && apiResponse.getResult() != null && !apiResponse.getResult().getConversion().isEmpty()) {
            System.out.println(apiResponse.getResult().getConversion().get(1).getRate());
        }
    }
}

