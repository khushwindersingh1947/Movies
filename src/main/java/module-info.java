module com.example.movies {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http;
    requires com.google.gson;

    opens com.example.movies to javafx.fxml, com.google.gson;
    exports com.example.movies;
}