package com.example.minirpglite3000;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller2 implements Initializable {
    @FXML
    private Button ConfirmButton;

    @FXML
    private TextField Name1;

    @FXML
    private TextField Name2;

    @FXML
    private TextField Name3;

    @FXML
    private TextField Name4;


    @FXML
    private ChoiceBox<String> ClassChoiceBox1;

    @FXML
    private ChoiceBox<String> ClassChoiceBox2;

    @FXML
    private ChoiceBox<String> ClassChoiceBox3;

    @FXML
    private ChoiceBox<String> ClassChoiceBox4;

    @FXML
    private ChoiceBox<Integer> NumberHeroComboBox;


    private String[] ClassList = {"Warrior", "Mage", "Hunter", "Healer"};
    private Integer[] Numbers = {1,2,3,4};





    @FXML
    void ConfirmClicked(ActionEvent event) throws IOException {
        Game.numHeroes = NumberHeroComboBox.getValue();
        Game.Hero1Name= Name1.getText();
        Game.Hero2Name= Name2.getText();
        Game.Hero3Name= Name3.getText();
        Game.Hero4Name= Name4.getText();
        if (ClassChoiceBox1.getSelectionModel().getSelectedItem() == "Warrior") {
            Game.Hero1Class = "1";
        }
        else if (ClassChoiceBox1.getSelectionModel().getSelectedItem() == "Mage") {
            Game.Hero1Class = "2";
        }
        else if (ClassChoiceBox1.getSelectionModel().getSelectedItem() == "Hunter") {
            Game.Hero1Class = "3";
        }
        else if (ClassChoiceBox1.getSelectionModel().getSelectedItem() == "Healer") {
            Game.Hero1Class = "4";
        }
        if (ClassChoiceBox2.getSelectionModel().getSelectedItem() == "Warrior") {
            Game.Hero2Class = "1";
        }
        else if (ClassChoiceBox2.getSelectionModel().getSelectedItem() == "Mage") {
            Game.Hero2Class = "2";
        }
        else if (ClassChoiceBox2.getSelectionModel().getSelectedItem() == "Hunter") {
            Game.Hero2Class = "3";
        }
        else if (ClassChoiceBox2.getSelectionModel().getSelectedItem() == "Healer") {
            Game.Hero2Class = "4";
        }
        if (ClassChoiceBox3.getSelectionModel().getSelectedItem() == "Warrior") {
            Game.Hero3Class = "1";
        }
        else if (ClassChoiceBox3.getSelectionModel().getSelectedItem() == "Mage") {
            Game.Hero3Class = "2";
        }
        else if (ClassChoiceBox3.getSelectionModel().getSelectedItem() == "Hunter") {
            Game.Hero3Class = "3";
        }
        else if (ClassChoiceBox3.getSelectionModel().getSelectedItem() == "Healer") {
            Game.Hero3Class = "4";
        }
        if (ClassChoiceBox4.getSelectionModel().getSelectedItem() == "Warrior") {
            Game.Hero4Class = "1";
        }
        else if (ClassChoiceBox4.getSelectionModel().getSelectedItem() == "Mage") {
            Game.Hero4Class = "2";
        }
        else if (ClassChoiceBox4.getSelectionModel().getSelectedItem() == "Hunter") {
            Game.Hero4Class = "3";
        }
        else if (ClassChoiceBox4.getSelectionModel().getSelectedItem() == "Healer") {
            Game.Hero4Class = "4";
        }
        Stage stage = (Stage) ConfirmButton.getScene().getWindow();
        stage.close();
        Parent root = FXMLLoader.load(getClass().getResource("Weapons.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("Don't forget your weapons !");
        stage.show();


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ClassChoiceBox1.getItems().addAll(ClassList);
        ClassChoiceBox2.getItems().addAll(ClassList);
        ClassChoiceBox3.getItems().addAll(ClassList);
        ClassChoiceBox4.getItems().addAll(ClassList);
        NumberHeroComboBox.getItems().addAll(Numbers);

    }
}
