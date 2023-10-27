package com.example.weatherforecast;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import org.json.simple.JSONObject;

import java.net.MalformedURLException;

public class MainController {

    @FXML
    private TextField cityInput;

    @FXML
    private Text weatherText;

    private final String openWeatherAPIKey = "eb6dcb043354af06c339fd85290af0b9";
    private final APIConnector weatherAPIConnector;

    public MainController() {
        weatherAPIConnector = new APIConnector(openWeatherAPIKey);
    }

    @FXML
    void getWeatherData(ActionEvent event) throws MalformedURLException {
        String city = cityInput.getText();
        JSONObject weatherData = getWeatherDataForCity(city);

        if (weatherData != null) {
            updateWeatherText(weatherData);
        } else {
            weatherText.setText("Weather data not found for " + city);
        }
    }

    public JSONObject getWeatherDataForCity(String city) {
        JSONObject weatherDataObject = weatherAPIConnector.getJSONObject(city);

        if (weatherDataObject != null) {
            return weatherDataObject;
        } else {
            return null;
        }
    }

    private void updateWeatherText(JSONObject weatherData) {
        Object mainObj = weatherData.get("main");
        Object windObj = weatherData.get("wind");
        Object humidityObj = null;

        if (mainObj != null) {
            JSONObject mainData = (JSONObject) mainObj;
            humidityObj = mainData.get("humidity");
        }

        if (mainObj != null && windObj != null) {
            JSONObject windData = (JSONObject) windObj;
            double tempKelvin = Double.parseDouble(((JSONObject) mainObj).get("temp").toString());
            double tempCelsius = tempKelvin - 273.15;

            String temp = tempCelsius + "°C";
            String windSpeed = windData.get("speed") + " m/s";
            String humidity = humidityObj != null ? humidityObj + "%" : "N/A";

            weatherText.setText(
                    "Temperature: " + temp + "\n" +
                            "Wind Speed: " + windSpeed + "\n" +
                            "Humidity: " + humidity
            );
        } else {
            weatherText.setText("Weather data not found for this city.");
        }
    }
}
