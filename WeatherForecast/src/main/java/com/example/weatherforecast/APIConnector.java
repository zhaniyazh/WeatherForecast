package com.example.weatherforecast;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class APIConnector {
    private final String apiKey;
    private final String apiUrl;

    public APIConnector(String apiKey) {
        this.apiKey = apiKey;
        this.apiUrl = "https://api.openweathermap.org/data/2.5/weather";
    }

    public JSONObject getJSONObject(String query) {
        try {
            URL url = new URL(apiUrl + "?q=" + query + "&appid=" + apiKey);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            int responseCode = conn.getResponseCode();

            if (responseCode != 200) {
                throw new RuntimeException("HttpResponseCode: " + responseCode);
            } else {
                StringBuilder response = new StringBuilder();
                InputStream in = conn.getInputStream();
                Scanner scanner = new Scanner(in);
                while (scanner.hasNext()) {
                    response.append(scanner.nextLine());
                }
                scanner.close();
                return (JSONObject) JSONValue.parse(response.toString()); // Using JSONValue for parsing
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

