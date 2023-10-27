# WeatherForecast
a javafx application for weather data using weather api connector

In the given application I've used weather api called openweathermap.org with my id(registered to website and got specific free id) which gives access to current weather data.

The APIConnector class is a Java utility designed to interact with the OpenWeatherMap API. This API enables you to retrieve weather data for specific locations.
Also, I've implemented JSON(JavaScript Object Notation), that is a data format used to represent structured information. In this code, JSON is used to organize and convey weather data from the API to the Java application.
1. Constructor: The APIConnector class has a constructor that accepts an API key as a parameter. This key is required to access the OpenWeatherMap API.
2. API URL: Within the constructor, the base URL for the OpenWeatherMap API is defined. It points to the specific link used to retrieve weather data.
3. getJSONObject Method: This method is responsible for making an HTTP request to the OpenWeatherMap API and retrieving JSON data. It accepts a query as input, typically representing a location.
4. HTTP Request: The method constructs a URL using the base URL, the query, and the API key. It then establishes an HTTP connection (HTTPURLConnection) to the API endpoint.
5. Response Code: After the connection is established, the HTTP response code is checked to ensure that the request was successful (HTTP 200 OK). If the response code is different, it throws a runtime exception.
6. Data Retrieval: If the response code is 200, it means a successful response was received. The method proceeds to retrieve the JSON data from the API. It collects and processes the response using a Scanner.
7. JSON Parsing: Once the JSON data is collected, it's parsed into a JSON object using JSONValue.parse. This object represents the structured weather information received from the API.
8. Exception Handling: In case netwoek breaks occur during the process, the method catches these exceptions and prints the error. Finally, the method returns the parsed JSON object to the caller. The caller can then work with this JSON object to extract specific weather-related information, such as temperature, humidity, and wind speed.

The MainController class where JavaFx applications' text, textfield and button features connects with the code part.
1.. Initialization: The class initializes the JavaFX controller. It defines JavaFX components using the @FXML annotation, such as a TextField for input and a Text element to display weather information.
2. API Key and APIConnector: It stores the OpenWeatherMap API key and creates an instance of the APIConnector class, which is responsible for making requests to the OpenWeatherMap API.
3. getWeatherData Method (used by Button Press): When a button is pressed in the user interface (get weather data), the getWeatherData method is called.
It retrieves the user's input, typically a city name, from the TextField.
4. getWeatherDataForCity Method: This method is called to fetch weather data for a specific city.
It uses the APIConnector to request data from the OpenWeatherMap API based on the city input.
5. Data Retrieval and Update: If the weather data is successfully retrieved (weatherData shouldn't be null), the updateWeatherText method is called.
6. updateWeatherText Method: This method is responsible for updating the user interface with weather information.
It checks if the main and wind objects in the JSON data are present. If so, it extracts temperature, wind speed, and humidity information.
7. Temperature Conversion: The temperature is initially in Kelvin. It's converted to Celsius by subtracting 273.15.
8. Display Weather Information: The method updates the Text element in the user interface with the temperature in Celsius, wind speed, and humidity (if available).
9. Error Handling: If the data is not available or if there's an issue with the API request, it displays an error message.

And at the end, in HelloApplication, by running the application's code, we can see the window with all informations. 
