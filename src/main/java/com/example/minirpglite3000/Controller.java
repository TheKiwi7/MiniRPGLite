package com.example.minirpglite3000;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller {

    @FXML
    private Button StartButton;

    @FXML
    void StartButtonClicked(ActionEvent event) throws IOException {
        Stage stage = (Stage) StartButton.getScene().getWindow();
        stage.close();
        Parent root = FXMLLoader.load(getClass().getResource("ChooseHeroTeam.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("Choose your fighters !");
        stage.show();


    }
}
