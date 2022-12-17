package com.example.minirpglite3000;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Main extends Application {



    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Main Menu.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("Welcome !");
        stage.show();


    }

}

