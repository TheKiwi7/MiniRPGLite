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
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller3 implements Initializable {

    @FXML
    private Button ReadyButton;

    @FXML
    private Label Hero1LabelMenu;

    @FXML
    private Label Hero2LabelMenu;

    @FXML
    private Label Hero3LabelMenu;

    @FXML
    private Label Hero4LabelMenu;

    @FXML
    private ChoiceBox<String> WeaponChoice1;

    @FXML
    private ChoiceBox<String> WeaponChoice2;

    @FXML
    private ChoiceBox<String> WeaponChoice3;

    @FXML
    private ChoiceBox<String> WeaponChoice4;

    private String Class1;
    private String Class2;
    private String Class3;
    private String Class4;
    @FXML
    void ReadyClicked(ActionEvent event) throws IOException {

        Game.Hero1Weapon= WeaponChoice1.getSelectionModel().getSelectedIndex()+1;
        Game.Hero2Weapon= WeaponChoice2.getSelectionModel().getSelectedIndex()+1;
        Game.Hero3Weapon= WeaponChoice3.getSelectionModel().getSelectedIndex()+1;
        Game.Hero4Weapon= WeaponChoice4.getSelectionModel().getSelectedIndex()+1;
        Stage stage = (Stage) ReadyButton.getScene().getWindow();
        stage.close();
        Game.createHeroTeam();
        Parent root = FXMLLoader.load(getClass().getResource("Fight.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("Fight !");
        stage.show();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        if(Game.Hero1Class =="1"){
            Class1 = "Warrior";
        }
        else if(Game.Hero1Class =="2"){
            Class1 = "Mage";
        }
        else if(Game.Hero1Class =="3"){
            Class1 = "Hunter";
        }
        else if(Game.Hero1Class =="4"){
            Class1 = "Healer";
        }
        if(Game.Hero2Class =="1"){
            Class2 = "Warrior";
        }
        else if(Game.Hero2Class =="2"){
            Class2 = "Mage";
        }
        else if(Game.Hero2Class =="3"){
            Class2 = "Hunter";
        }
        else if(Game.Hero2Class =="4"){
            Class2 = "Healer";
        }
        if(Game.Hero3Class =="1"){
            Class3 = "Warrior";
        }
        else if(Game.Hero3Class =="2"){
            Class3 = "Mage";
        }
        else if(Game.Hero3Class =="3"){
            Class3 = "Hunter";
        }
        else if(Game.Hero3Class =="4"){
            Class3 = "Healer";
        }
        if(Game.Hero4Class =="1"){
            Class4 = "Warrior";
        }
        else if(Game.Hero4Class =="2"){
            Class4 = "Mage";
        }
        else if(Game.Hero4Class =="3"){
            Class4 = "Hunter";
        }
        else if(Game.Hero4Class =="4"){
            Class4 = "Healer";
        }
        if(Game.numHeroes == 1){
            Hero1LabelMenu.setText(Game.Hero1Name + " the " + Class1);
            Hero2LabelMenu.setText(" ");
            Hero3LabelMenu.setText(" ");
            Hero4LabelMenu.setText(" ");
            WeaponChoice2.setDisable(true);
            WeaponChoice3.setDisable(true);
            WeaponChoice4.setDisable(true);
        }
        if(Game.numHeroes == 2){
            Hero1LabelMenu.setText(Game.Hero1Name + " the " + Class1);
            Hero2LabelMenu.setText(Game.Hero2Name + " the " + Class2);
            Hero3LabelMenu.setText(" ");
            Hero4LabelMenu.setText(" ");
            WeaponChoice3.setDisable(true);
            WeaponChoice4.setDisable(true);
        }
        if(Game.numHeroes == 3){
            Hero1LabelMenu.setText(Game.Hero1Name +" the " + Class1);
            Hero2LabelMenu.setText(Game.Hero2Name +" the " + Class2);
            Hero3LabelMenu.setText(Game.Hero3Name +" the " + Class3);
            Hero4LabelMenu.setText(" ");
            WeaponChoice4.setDisable(true);
        }
        if(Game.numHeroes == 4){
            Hero1LabelMenu.setText(Game.Hero1Name +" the " + Class1);
            Hero2LabelMenu.setText(Game.Hero2Name +" the " + Class2);
            Hero3LabelMenu.setText(Game.Hero3Name +" the " + Class3);
            Hero4LabelMenu.setText(Game.Hero4Name +" the " + Class4);
        }
        ObservableList<String> ObservableStringArray;
        if (Game.Hero1Class == "1") {
            WeaponChoice1.setItems(ObservableStringArray = FXCollections.observableArrayList("Sword - Damage: 10 - Mana Cost: 10",
                    "Axe - Damage: 15 - Mana Cost: 15", "Mace - Damage: 20 - Mana Cost: 20", "Spear - Damage: 25 - Mana Cost: 25"));
        }
        if (Game.Hero1Class == "2") {
            WeaponChoice1.setItems(ObservableStringArray = FXCollections.observableArrayList("Staff - Damage: 10 - Mana Cost: 20",
                    "Wand - Damage: 15 - Mana Cost: 30", "Book - Damage: 20 - Mana Cost: 40", "Orb - Damage: 25 - Mana Cost: 50"));
        }
        if (Game.Hero1Class == "3") {
            WeaponChoice1.setItems(ObservableStringArray = FXCollections.observableArrayList("Bow - Damage: 10 - Mana Cost: 5",
                    "Crossbow - Damage: 15 - Mana Cost: 10", "Rifle - Damage: 20 - Mana Cost: 15", "Sniper - Damage: 25 - Mana Cost: 20"));
        }
        if (Game.Hero1Class == "4") {
            WeaponChoice1.setItems(ObservableStringArray = FXCollections.observableArrayList("Staff - Damage: 10 - Mana Cost: 30",
                    "Wand - Damage: 15 - Mana Cost: 45", "Book - Damage: 20 - Mana Cost: 60", "Orb - Damage: 25 - Mana Cost: 75"));
        }
        if (Game.Hero2Class == "1") {
            WeaponChoice2.setItems(ObservableStringArray = FXCollections.observableArrayList("Sword - Damage: 10 - Mana Cost: 10",
                    "Axe - Damage: 15 - Mana Cost: 15", "Mace - Damage: 20 - Mana Cost: 20", "Spear - Damage: 25 - Mana Cost: 25"));
        }
        if (Game.Hero2Class == "2") {
            WeaponChoice2.setItems(ObservableStringArray = FXCollections.observableArrayList("Staff - Damage: 10 - Mana Cost: 20",
                    "Wand - Damage: 15 - Mana Cost: 30", "Book - Damage: 20 - Mana Cost: 40", "Orb - Damage: 25 - Mana Cost: 50"));
        }
        if (Game.Hero2Class == "3") {
            WeaponChoice2.setItems(ObservableStringArray = FXCollections.observableArrayList("Bow - Damage: 10 - Mana Cost: 5",
                    "Crossbow - Damage: 15 - Mana Cost: 10", "Rifle - Damage: 20 - Mana Cost: 15", "Sniper - Damage: 25 - Mana Cost: 20"));
        }
        if (Game.Hero2Class == "4") {
            WeaponChoice2.setItems(ObservableStringArray = FXCollections.observableArrayList("Staff - Damage: 10 - Mana Cost: 30",
                    "Wand - Damage: 15 - Mana Cost: 45", "Book - Damage: 20 - Mana Cost: 60", "Orb - Damage: 25 - Mana Cost: 75"));
        }
        if (Game.Hero3Class == "1") {
            WeaponChoice3.setItems(ObservableStringArray = FXCollections.observableArrayList("Sword - Damage: 10 - Mana Cost: 10",
                    "Axe - Damage: 15 - Mana Cost: 15", "Mace - Damage: 20 - Mana Cost: 20", "Spear - Damage: 25 - Mana Cost: 25"));
        }
        if (Game.Hero3Class == "2") {
            WeaponChoice3.setItems(ObservableStringArray = FXCollections.observableArrayList("Staff - Damage: 10 - Mana Cost: 20",
                    "Wand - Damage: 15 - Mana Cost: 30", "Book - Damage: 20 - Mana Cost: 40", "Orb - Damage: 25 - Mana Cost: 50"));
        }
        if (Game.Hero3Class == "3") {
            WeaponChoice3.setItems(ObservableStringArray = FXCollections.observableArrayList("Bow - Damage: 10 - Mana Cost: 5",
                    "Crossbow - Damage: 15 - Mana Cost: 10", "Rifle - Damage: 20 - Mana Cost: 15", "Sniper - Damage: 25 - Mana Cost: 20"));
        }
        if (Game.Hero3Class == "4") {
            WeaponChoice3.setItems(ObservableStringArray = FXCollections.observableArrayList("Staff - Damage: 10 - Mana Cost: 30",
                    "Wand - Damage: 15 - Mana Cost: 45", "Book - Damage: 20 - Mana Cost: 60", "Orb - Damage: 25 - Mana Cost: 75"));
        }
        if (Game.Hero4Class == "1") {
            WeaponChoice4.setItems(ObservableStringArray = FXCollections.observableArrayList("Sword - Damage: 10 - Mana Cost: 10",
                    "Axe - Damage: 15 - Mana Cost: 15", "Mace - Damage: 20 - Mana Cost: 20", "Spear - Damage: 25 - Mana Cost: 25"));
        }
        if (Game.Hero4Class == "2") {
            WeaponChoice4.setItems(ObservableStringArray = FXCollections.observableArrayList("Staff - Damage: 10 - Mana Cost: 20",
                    "Wand - Damage: 15 - Mana Cost: 30", "Book - Damage: 20 - Mana Cost: 40", "Orb - Damage: 25 - Mana Cost: 50"));
        }
        if (Game.Hero4Class == "3") {
            WeaponChoice4.setItems(ObservableStringArray = FXCollections.observableArrayList("Bow - Damage: 10 - Mana Cost: 5",
                    "Crossbow - Damage: 15 - Mana Cost: 10", "Rifle - Damage: 20 - Mana Cost: 15", "Sniper - Damage: 25 - Mana Cost: 20"));
        }
        if (Game.Hero4Class == "4") {
            WeaponChoice4.setItems(ObservableStringArray = FXCollections.observableArrayList("Staff - Damage: 10 - Mana Cost: 30",
                    "Wand - Damage: 15 - Mana Cost: 45", "Book - Damage: 20 - Mana Cost: 60", "Orb - Damage: 25 - Mana Cost: 75"));
        }

    }
}
