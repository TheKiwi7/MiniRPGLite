module com.example.minirpglite3000 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.minirpglite3000 to javafx.fxml;
    exports com.example.minirpglite3000;
}