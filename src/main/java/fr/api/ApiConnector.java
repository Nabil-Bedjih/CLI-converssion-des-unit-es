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

    public ApiResponse getcuurencyFromApi(String cur) {
        try {
            KEY = configReader.readConfigFile(getClass().getResource("/config.txt"));
            String urlString = "https://api.devises.zone/v1/full/" + cur + "/json?key=" + KEY;
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            int status = connection.getResponseCode();

            BufferedReader reader;
            String line;
            StringBuffer responseContent = new StringBuffer();

            ApiResponse apiResponse = null;
            if (status > 299) {
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                while ((line = reader.readLine()) != null) {
                    responseContent.append(line);
                }
                reader.close();
                throw new IOException("Erreur lors de la requête à l'API : " + responseContent.toString());
            } else {
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                while ((line = reader.readLine()) != null) {
                    responseContent.append(line);
                }
                reader.close();

                ObjectMapper objectMapper = new ObjectMapper();
                apiResponse = objectMapper.readValue(responseContent.toString(), ApiResponse.class);

                System.out.println("Status: " + apiResponse.getStatus());
            }

            connection.disconnect();
            return apiResponse;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<Double> getRatesForElements(ApiResponse apiResponse, String[] tab) {
        List<Double> ratesList = new ArrayList<>();
        for (String element : tab) {
            for (fr.api.Conversion conversion : apiResponse.getResult().getConversion()) {
                if (conversion.getTo().equals(element)) {
                    ratesList.add(conversion.getRate());
                }
            }
        }

        return ratesList;
    }

    public static void main(String[] args) {
        ApiConnector apiConnector = new ApiConnector();
        ApiResponse apiResponse = apiConnector.getcuurencyFromApi("DZD");

        String[] tab = {"USD", "EUR", "BGN"};
        List<Double> ratesList = getRatesForElements(apiResponse, tab);
        for (double rate : ratesList) {
            System.out.println("Rate : " + rate);
        }

        if (apiResponse != null) {
            System.out.println(apiResponse.getResult().getConversion().get(1).getRate());
        } else {
            System.out.println("Erreur lors de la récupération des données depuis l'API.");
        }
    }


}
