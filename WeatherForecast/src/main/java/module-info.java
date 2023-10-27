module com.example.weatherforecast {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires json.simple;

    opens com.example.weatherforecast to javafx.fxml;
    exports com.example.weatherforecast;
}