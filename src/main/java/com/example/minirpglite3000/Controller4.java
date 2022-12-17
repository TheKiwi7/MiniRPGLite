package com.example.minirpglite3000;
import javafx.collections.FXCollections;
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
import java.util.ArrayList;
import java.util.List;

import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import static com.example.minirpglite3000.Game.*;

public class Controller4 implements Initializable {

    @FXML
    private Button ButtonPrize;

    @FXML
    private ChoiceBox<String> ChoicePrizeBox;
    @FXML
    private Button AttackButton;


    @FXML
    private Button CapsuleButton;

    @FXML
    private ChoiceBox<String> ChoiceEnemyAttack;

    @FXML
    private ChoiceBox<String> ChoiceHeroHeal;

    @FXML
    private Label FightEnemyName1;

    @FXML
    private Label FightEnemyName2;

    @FXML
    private Label FightEnemyName3;

    @FXML
    private Label FightEnemyName4;

    @FXML
    private Label FightHeroName1;

    @FXML
    private Label FightHeroName2;

    @FXML
    private Label FightHeroName3;

    @FXML
    private Label FightHeroName4;

    @FXML
    private Button SpecialButton;

    @FXML
    private Button WaitButton;

    @FXML
    private Label FightInfo;

    @FXML
    private Label CapsuleLabel;

    @FXML
    private Label TurnInfo;

    public int currentHP;
    public int PrizeTurn;



    @FXML
    void ConfirmClicked(ActionEvent event) {
        if (ChoicePrizeBox.getSelectionModel().getSelectedIndex() == 0) {
            heroTeam.get(PrizeTurn).setHP(heroTeam.get(PrizeTurn).getHP() + 10);
            PrizeTurn++;
            winprize();
        } else if (ChoicePrizeBox.getSelectionModel().getSelectedIndex() == 1) {
            heroTeam.get(PrizeTurn).setMP(heroTeam.get(PrizeTurn).getMP() + 10);
            PrizeTurn++;
            winprize();
        } else if (ChoicePrizeBox.getSelectionModel().getSelectedIndex() == 2) {
            heroTeam.get(PrizeTurn).setCapsule(heroTeam.get(PrizeTurn).getCapsule() + 1);
            PrizeTurn++;
            winprize();
        } else {
            FightInfo.setText("You have to choose something!");
        }
    }

    @FXML
    void AttackClicked(ActionEvent event) {
        if (ChoiceEnemyAttack.getSelectionModel().isEmpty() == true) {
            FightInfo.setVisible(true);
            FightInfo.setText("Choose an enemy to attack !");
            fightinterface();
        }
        else {
            ChoiceEnemy = ChoiceEnemyAttack.getSelectionModel().getSelectedIndex();
            Enemy enemyc = enemyTeam.get(ChoiceEnemy);
            Hero hero = heroTeam.get(TurnHero);
            FightInfo.setVisible(true);
            FightInfo.setText(hero.getName() + " attacked " + enemyc.getName() + " the " + enemyc.getEnemyClass() + " for " + hero.getWeapon().getDamage() + " damage");
            enemyc.setCurrentHealth(enemyc.getCurrentHealth() - hero.getWeapon().getDamage());
            TurnHero++;
            if (enemyc.getCurrentHealth() <= 0) {
                enemyTeam.remove(enemyc);
            }
            fightinterface();
        }

    }
    public void winprize(){
        ChoicePrizeBox.getItems().clear();
        if (heroTeam.size() > PrizeTurn) {
            FightInfo.setVisible(true);
            TurnInfo.setVisible(false);
            AttackButton.setVisible(false);
            SpecialButton.setVisible(false);
            WaitButton.setVisible(false);
            ChoiceEnemyAttack.setVisible(false);
            ChoiceHeroHeal.setVisible(false);
            CapsuleButton.setVisible(false);
            ChoicePrizeBox.setVisible(true);
            ButtonPrize.setVisible(true);
            AttackButton.setDisable(true);
            SpecialButton.setDisable(true);
            WaitButton.setDisable(true);
            ChoiceEnemyAttack.setDisable(true);
            ChoiceHeroHeal.setDisable(true);
            CapsuleButton.setDisable(true);
            ChoicePrizeBox.setDisable(false);
            ButtonPrize.setDisable(false);
            FightEnemyName1.setVisible(false);
            FightEnemyName2.setVisible(false);
            FightEnemyName3.setVisible(false);
            FightEnemyName4.setVisible(false);
            ChoicePrizeBox.getItems().addAll("+10 Health", "+10 Mana", "1 Capsule");
            if (PrizeTurn == 0){
                FightInfo.setText("You won the fight ! Choose your prize for "+ heroTeam.get(0).getName()+ " the " + heroTeam.get(0).getClassHero());
            } else if (PrizeTurn == 1){
                FightInfo.setText("You won the fight ! Choose your prize for "+ heroTeam.get(1).getName()+ " the " + heroTeam.get(1).getClassHero());
            } else if (PrizeTurn == 2){
                FightInfo.setText("You won the fight ! Choose your prize for "+ heroTeam.get(2).getName()+ " the " + heroTeam.get(2).getClassHero());
            } else if (PrizeTurn == 3){
                FightInfo.setText("You won the fight ! Choose your prize for "+ heroTeam.get(3).getName()+ " the " + heroTeam.get(3).getClassHero());
            }
        }
        else {
            PrizeTurn = 0;
            TurnHero = 0;
            FightInfo.setVisible(false);
            AttackButton.setVisible(true);
            SpecialButton.setVisible(true);
            WaitButton.setVisible(true);
            ChoiceEnemyAttack.setVisible(true);
            ChoiceHeroHeal.setVisible(true);
            CapsuleButton.setVisible(true);
            ChoicePrizeBox.setVisible(false);
            ButtonPrize.setVisible(false);
            AttackButton.setDisable(false);
            SpecialButton.setDisable(false);
            WaitButton.setDisable(false);
            ChoiceEnemyAttack.setDisable(false);
            ChoiceHeroHeal.setDisable(false);
            CapsuleButton.setDisable(false);
            ChoicePrizeBox.setDisable(true);
            ButtonPrize.setDisable(true);
            ChoicePrizeBox.getItems().clear();
            createEnemyTeam(numHeroes, heroTeam);
            for (Hero hero : heroTeam) {
                hero.setCurrentHP(hero.getHP());
                hero.setCurrentMP(hero.getMP());
            }
            fightinterface();
        }

    }

    public void enemyAttackinterface()
    {

        if (round < 5) {
            for (Enemy enemy : enemyTeam){
                int index = (int) (Math.random() * heroTeam.size());
                while (heroTeam.get(index).getCurrentHP() <= 0) {
                    index = (int) (Math.random() * heroTeam.size());
                }
                Hero hero = heroTeam.get(index);
                hero.setCurrentHP(hero.getCurrentHP() - enemy.getAttack());
                System.out.println(enemy.getName() + " the " + enemy.getEnemyClass() + " attacked " + hero.getName() + " for " + enemy.getAttack() + " damage");
                FightInfo.setText(enemy.getName() + " the " + enemy.getEnemyClass() + " attacked " + hero.getName() + " for " + enemy.getAttack() + " damage");
            }

        }
        else {
            for (Hero hero2 : heroTeam) {
                hero2.setCurrentHP(hero2.getCurrentHP() - enemyTeam.get(0).getAttack());
                System.out.println(enemyTeam.get(0).getName() + " the " + enemyTeam.get(0).getEnemyClass() + " attacked " + hero2.getName() + " for " + enemyTeam.get(0).getAttack() + " damage");
                FightInfo.setText(enemyTeam.get(0).getName() + " the " + enemyTeam.get(0).getEnemyClass() + " attacked " + hero2.getName() + " for " + enemyTeam.get(0).getAttack() + " damage");
            }
        }

        TurnHero = 0;
        fightinterface();
    }
    public void fightinterface(){

        for (Hero hero2 : heroTeam) {
            System.out.println(heroTeam.indexOf(hero2));
            if (hero2.getCurrentHP() <= 0) {
                System.out.println(hero2.getName() + " is dead");
                heroTeam.remove(hero2);
            }
            if (heroTeam.size() == 0) {
                System.out.println("You lost the fight");
                System.exit(0);
            }

        }
        if (enemyTeam.size() == 0) {
            if (round < 5) {
                System.out.println("You won the fight");
                winprize();

            }
            else {
                TurnInfo.setVisible(false);
                System.out.println("You won the game");
                FightInfo.setVisible(true);
                FightInfo.setText("You won the game !");
            }
            return;

        }
        else {
            for (Enemy enemy2 : enemyTeam) {
                if (enemy2.getCurrentHealth() <= 0) {
                    System.out.println(enemy2.getName() + " is dead");
                    enemyTeam.remove(enemy2);
                    fightinterface();
                }

            }
        }
        if (TurnHero >= heroTeam.size()) {
            enemyAttackinterface();
        }
        System.out.println("Turn of " + heroTeam.get(TurnHero).getName());
        TurnInfo.setVisible(true);
        TurnInfo.setText("It's " + heroTeam.get(TurnHero).getName() + " the " + heroTeam.get(TurnHero).getClassHero() + "'s turn");
        if (heroTeam.size() == 1) {
            FightHeroName1.setVisible(true);
            FightHeroName2.setVisible(false);
            FightHeroName3.setVisible(false);
            FightHeroName4.setVisible(false);
            FightHeroName1.setText(heroTeam.get(0).getName() + " the " + heroTeam.get(0).getClassHero() + System.lineSeparator() + "Health: " + heroTeam.get(0).getCurrentHP() + "|" + heroTeam.get(0).getHP() + " - Attack: " + heroTeam.get(0).getWeapon().getDamage() + System.lineSeparator() + "Mana: " + heroTeam.get(0).getCurrentMP() + "|" + heroTeam.get(0).getMP() + " - Mana Cost: " + heroTeam.get(0).getWeapon().getManaCost());
        }
        if (heroTeam.size() == 2) {
            FightHeroName1.setVisible(true);
            FightHeroName2.setVisible(true);
            FightHeroName3.setVisible(false);
            FightHeroName4.setVisible(false);
            FightHeroName1.setText(heroTeam.get(0).getName() + " the " + heroTeam.get(0).getClassHero() + System.lineSeparator() + "Health: " + heroTeam.get(0).getCurrentHP() + "|" + heroTeam.get(0).getHP() + " - Attack: " + heroTeam.get(0).getWeapon().getDamage() + System.lineSeparator() + "Mana: " + heroTeam.get(0).getCurrentMP() + "|" + heroTeam.get(0).getMP() + " - Mana Cost: " + heroTeam.get(0).getWeapon().getManaCost());
            FightHeroName2.setText(heroTeam.get(1).getName() + " the " + heroTeam.get(1).getClassHero() + System.lineSeparator() + "Health: " + heroTeam.get(1).getCurrentHP() + "|" + heroTeam.get(1).getHP() + " - Attack: " + heroTeam.get(1).getWeapon().getDamage() + System.lineSeparator() + "Mana: " + heroTeam.get(1).getCurrentMP() + "|" + heroTeam.get(1).getMP() + " - Mana Cost: " + heroTeam.get(1).getWeapon().getManaCost());
        }
        if (heroTeam.size() == 3) {
            FightHeroName1.setVisible(true);
            FightHeroName2.setVisible(true);
            FightHeroName3.setVisible(true);
            FightHeroName4.setVisible(false);
            FightHeroName1.setText(heroTeam.get(0).getName() + " the " + heroTeam.get(0).getClassHero() + System.lineSeparator() + "Health: " + heroTeam.get(0).getCurrentHP() + "|" + heroTeam.get(0).getHP() + " - Attack: " + heroTeam.get(0).getWeapon().getDamage() + System.lineSeparator() + "Mana: " + heroTeam.get(0).getCurrentMP() + "|" + heroTeam.get(0).getMP() + " - Mana Cost: " + heroTeam.get(0).getWeapon().getManaCost());
            FightHeroName2.setText(heroTeam.get(1).getName() + " the " + heroTeam.get(1).getClassHero() + System.lineSeparator() + "Health: " + heroTeam.get(1).getCurrentHP() + "|" + heroTeam.get(1).getHP() + " - Attack: " + heroTeam.get(1).getWeapon().getDamage() + System.lineSeparator() + "Mana: " + heroTeam.get(1).getCurrentMP() + "|" + heroTeam.get(1).getMP() + " - Mana Cost: " + heroTeam.get(1).getWeapon().getManaCost());
            FightHeroName3.setText(heroTeam.get(2).getName() + " the " + heroTeam.get(2).getClassHero() + System.lineSeparator() + "Health: " + heroTeam.get(2).getCurrentHP() + "|" + heroTeam.get(2).getHP() + " - Attack: " + heroTeam.get(2).getWeapon().getDamage() + System.lineSeparator() + "Mana: " + heroTeam.get(2).getCurrentMP() + "|" + heroTeam.get(2).getMP() + " - Mana Cost: " + heroTeam.get(2).getWeapon().getManaCost());
        }
        if (heroTeam.size() == 4) {
            FightHeroName1.setVisible(true);
            FightHeroName2.setVisible(true);
            FightHeroName3.setVisible(true);
            FightHeroName4.setVisible(true);
            FightHeroName1.setText(heroTeam.get(0).getName() + " the " + heroTeam.get(0).getClassHero() + System.lineSeparator() + "Health: " + heroTeam.get(0).getCurrentHP() + "|" + heroTeam.get(0).getHP() + " - Attack: " + heroTeam.get(0).getWeapon().getDamage() + System.lineSeparator() + "Mana: " + heroTeam.get(0).getCurrentMP() + "|" + heroTeam.get(0).getMP() + " - Mana Cost: " + heroTeam.get(0).getWeapon().getManaCost());
            FightHeroName2.setText(heroTeam.get(1).getName() + " the " + heroTeam.get(1).getClassHero() + System.lineSeparator() + "Health: " + heroTeam.get(1).getCurrentHP() + "|" + heroTeam.get(1).getHP() + " - Attack: " + heroTeam.get(1).getWeapon().getDamage() + System.lineSeparator() + "Mana: " + heroTeam.get(1).getCurrentMP() + "|" + heroTeam.get(1).getMP() + " - Mana Cost: " + heroTeam.get(1).getWeapon().getManaCost());
            FightHeroName3.setText(heroTeam.get(2).getName() + " the " + heroTeam.get(2).getClassHero() + System.lineSeparator() + "Health: " + heroTeam.get(2).getCurrentHP() + "|" + heroTeam.get(2).getHP() + " - Attack: " + heroTeam.get(2).getWeapon().getDamage() + System.lineSeparator() + "Mana: " + heroTeam.get(2).getCurrentMP() + "|" + heroTeam.get(2).getMP() + " - Mana Cost: " + heroTeam.get(2).getWeapon().getManaCost());
            FightHeroName4.setText(heroTeam.get(3).getName() + " the " + heroTeam.get(3).getClassHero() + System.lineSeparator() + "Health: " + heroTeam.get(3).getCurrentHP() + "|" + heroTeam.get(3).getHP() + " - Attack: " + heroTeam.get(3).getWeapon().getDamage() + System.lineSeparator() + "Mana: " + heroTeam.get(3).getCurrentMP() + "|" + heroTeam.get(3).getMP() + " - Mana Cost: " + heroTeam.get(3).getWeapon().getManaCost());
        }
        if (enemyTeam.size() == 1) {
            FightEnemyName1.setVisible(true);
            FightEnemyName2.setVisible(false);
            FightEnemyName3.setVisible(false);
            FightEnemyName4.setVisible(false);
            FightEnemyName1.setText(enemyTeam.get(0).getName() + " the " + enemyTeam.get(0).getEnemyClass() + System.lineSeparator() + "Health: " + enemyTeam.get(0).getCurrentHealth() + "|" + enemyTeam.get(0).getHealth() + " - Attack: " + enemyTeam.get(0).getAttack());
        }
        if (enemyTeam.size() == 2) {
            FightEnemyName1.setVisible(true);
            FightEnemyName2.setVisible(true);
            FightEnemyName3.setVisible(false);
            FightEnemyName4.setVisible(false);
            FightEnemyName1.setText(enemyTeam.get(0).getName() + " the " + enemyTeam.get(0).getEnemyClass() + System.lineSeparator() + "Health: " + enemyTeam.get(0).getCurrentHealth() + "|" + enemyTeam.get(0).getHealth() + " - Attack: " + enemyTeam.get(0).getAttack());
            FightEnemyName2.setText(enemyTeam.get(1).getName() + " the " + enemyTeam.get(1).getEnemyClass() + System.lineSeparator() + "Health: " + enemyTeam.get(1).getCurrentHealth() + "|" + enemyTeam.get(1).getHealth() + " - Attack: " + enemyTeam.get(1).getAttack());
        }
        if (enemyTeam.size() == 3) {
            FightEnemyName1.setVisible(true);
            FightEnemyName2.setVisible(true);
            FightEnemyName3.setVisible(true);
            FightEnemyName4.setVisible(false);
            FightEnemyName1.setText(enemyTeam.get(0).getName() + " the " + enemyTeam.get(0).getEnemyClass() + System.lineSeparator() + "Health: " + enemyTeam.get(0).getCurrentHealth() + "|" + enemyTeam.get(0).getHealth() + " - Attack: " + enemyTeam.get(0).getAttack());
            FightEnemyName2.setText(enemyTeam.get(1).getName() + " the " + enemyTeam.get(1).getEnemyClass() + System.lineSeparator() + "Health: " + enemyTeam.get(1).getCurrentHealth() + "|" + enemyTeam.get(1).getHealth() + " - Attack: " + enemyTeam.get(1).getAttack());
            FightEnemyName3.setText(enemyTeam.get(2).getName() + " the " + enemyTeam.get(2).getEnemyClass() + System.lineSeparator() + "Health: " + enemyTeam.get(2).getCurrentHealth() + "|" + enemyTeam.get(2).getHealth() + " - Attack: " + enemyTeam.get(2).getAttack());
        }
        if (enemyTeam.size() == 4) {
            FightEnemyName1.setVisible(true);
            FightEnemyName2.setVisible(true);
            FightEnemyName3.setVisible(true);
            FightEnemyName4.setVisible(true);
            FightEnemyName1.setText(enemyTeam.get(0).getName() + " the " + enemyTeam.get(0).getEnemyClass() + System.lineSeparator() + "Health: " + enemyTeam.get(0).getCurrentHealth() + "|" + enemyTeam.get(0).getHealth() + " - Attack: " + enemyTeam.get(0).getAttack());
            FightEnemyName2.setText(enemyTeam.get(1).getName() + " the " + enemyTeam.get(1).getEnemyClass() + System.lineSeparator() + "Health: " + enemyTeam.get(1).getCurrentHealth() + "|" + enemyTeam.get(1).getHealth() + " - Attack: " + enemyTeam.get(1).getAttack());
            FightEnemyName3.setText(enemyTeam.get(2).getName() + " the " + enemyTeam.get(2).getEnemyClass() + System.lineSeparator() + "Health: " + enemyTeam.get(2).getCurrentHealth() + "|" + enemyTeam.get(2).getHealth() + " - Attack: " + enemyTeam.get(2).getAttack());
            FightEnemyName4.setText(enemyTeam.get(3).getName() + " the " + enemyTeam.get(3).getEnemyClass() + System.lineSeparator() + "Health: " + enemyTeam.get(3).getCurrentHealth() + "|" + enemyTeam.get(3).getHealth() + " - Attack: " + enemyTeam.get(3).getAttack());
        }

        List<String> enemyList = new ArrayList<>();
        enemyList.add(enemyTeam.get(0).getName() + " the " + enemyTeam.get(0).getEnemyClass());
        if (enemyTeam.size() > 1) {
            enemyList.add(enemyTeam.get(1).getName() + " the " + enemyTeam.get(1).getEnemyClass());
        }
        if (enemyTeam.size() > 2) {
            enemyList.add(enemyTeam.get(2).getName() + " the " + enemyTeam.get(2).getEnemyClass());
        }
        if (enemyTeam.size() > 3) {
            enemyList.add(enemyTeam.get(3).getName() + " the " + enemyTeam.get(3).getEnemyClass());
        }
        ChoiceEnemyAttack.setItems(FXCollections.observableArrayList(enemyList));
        List<String> heroList = new ArrayList<>();
        heroList.add(heroTeam.get(0).getName() + " the " + heroTeam.get(0).getClassHero());
        if (heroTeam.size() > 1) {
            heroList.add(heroTeam.get(1).getName() + " the " + heroTeam.get(1).getClassHero());
        }
        if (heroTeam.size() > 2) {
            heroList.add(heroTeam.get(2).getName() + " the " + heroTeam.get(2).getClassHero());
        }
        if (heroTeam.size() > 3) {
            heroList.add(heroTeam.get(3).getName() + " the " + heroTeam.get(3).getClassHero());
        }
        ChoiceHeroHeal.setItems(FXCollections.observableArrayList(heroList));
    }

    @FXML
    void CapsuleClicked(ActionEvent event) {
        if (heroTeam.get(TurnHero).getCapsule() > 0){
            heroTeam.get(TurnHero).setCapsule(heroTeam.get(TurnHero).getCapsule() - 1);
            for (Hero hero : heroTeam) {
                hero.setCurrentHP(hero.getHP()+30);
                if (hero.getCurrentHP() > hero.getHP()){
                    hero.setCurrentHP(hero.getHP());
                    FightInfo.setVisible(true);
                    FightInfo.setText("Everybody got healed for 30 HP!");
                }
            }
            TurnHero++;
            fightinterface();
        }
        else {
            FightInfo.setVisible(true);
            FightInfo.setText("You don't have any capsules!");
        }

    }

    @FXML
    void SpecialClicked(ActionEvent event) throws IOException {
        if (heroTeam.get(TurnHero).getCurrentMP() >= heroTeam.get(TurnHero).getWeapon().getManaCost()){
            if (heroTeam.get(TurnHero).getClassHero() == "Healer")
            {
                if (ChoiceHeroHeal.getSelectionModel().isEmpty() == true) {
                    FightInfo.setVisible(true);
                    FightInfo.setText("Choose an Hero to Heal !");
                    fightinterface();
                }
                else {
                    ChoiceHero = ChoiceHeroHeal.getSelectionModel().getSelectedIndex();
                    Enemy enemyc = enemyTeam.get(0);
                    Hero hero = heroTeam.get(TurnHero);
                    Hero heroc = heroTeam.get(ChoiceHero);
                    currentHP = heroc.getCurrentHP();
                    heroc.setCurrentHP(heroc.getCurrentHP() + 50);
                    if (heroc.getCurrentHP() > heroc.getHP()) {
                        heroc.setCurrentHP(heroc.getHP());
                    }
                    hero.setCurrentMP(hero.getCurrentMP() - hero.getWeapon().getManaCost());
                    FightInfo.setVisible(true);
                    FightInfo.setText(hero.getName() + " healed " + heroc.getName() + " the " + heroc.getClassHero() + " for " + (heroc.getCurrentHP() - currentHP) + " HP!");
                    TurnHero++;
                    fightinterface();
                }
            }
            else{
                if (ChoiceEnemyAttack.getSelectionModel().isEmpty() == true) {
                    FightInfo.setVisible(true);
                    FightInfo.setText("Choose an enemy to attack !");
                    fightinterface();
                }
                else {
                    ChoiceEnemy = ChoiceEnemyAttack.getSelectionModel().getSelectedIndex();
                    Enemy enemyc = enemyTeam.get(ChoiceEnemy);
                    Hero hero = heroTeam.get(TurnHero);
                    enemyc.setCurrentHealth(enemyc.getCurrentHealth() - hero.getWeapon().getDamage() * 2);
                    if (enemyc.getCurrentHealth() <= 0) {
                        enemyTeam.remove(enemyc);
                    }
                    FightInfo.setVisible(true);
                    FightInfo.setText(hero.getName() + " Destroyed " + enemyc.getName() + " the " + enemyc.getEnemyClass() + " for " + hero.getWeapon().getDamage()*2 + " damage");
                    TurnHero++;
                    hero.setCurrentMP(hero.getCurrentMP() - hero.getWeapon().getManaCost());
                    fightinterface();
                }
            }
        }
        else {
            FightInfo.setVisible(true);
            FightInfo.setText("You don't have enough MP!");
            fightinterface();
        }

    }

    @FXML
    void WaitClicked(ActionEvent event) {
        FightInfo.setVisible(true);
        FightInfo.setText("You waited and gained back 20% of your MP!");
        heroTeam.get(TurnHero).setCurrentMP(heroTeam.get(TurnHero).getCurrentMP() + (int) (heroTeam.get(TurnHero).getMP() * 0.2));
        if (heroTeam.get(TurnHero).getCurrentMP() > heroTeam.get(TurnHero).getMP()) {
            heroTeam.get(TurnHero).setCurrentMP(heroTeam.get(TurnHero).getMP());
        }
        TurnHero++;
        fightinterface();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for (Hero hero2 : heroTeam) {
            System.out.println(heroTeam.indexOf(hero2));


            if (heroTeam.indexOf(hero2) == 0) {
                FightHeroName1.setVisible(true);
                FightHeroName1.setText(hero2.getName() + " the " + hero2.getClassHero() + System.lineSeparator() + "Health: " + hero2.getCurrentHP() + "|" + hero2.getHP() + " - Attack: " + hero2.getWeapon().getDamage() + System.lineSeparator() + "Mana: " + hero2.getMP() + "|" + hero2.getCurrentMP() + " - Mana Cost: " + hero2.getWeapon().getManaCost());
            }
            if (heroTeam.indexOf(hero2) == 1) {
                FightHeroName2.setVisible(true);
                FightHeroName2.setText(hero2.getName() + " the " + hero2.getClassHero() + System.lineSeparator() + "Health: " + hero2.getCurrentHP() + "|" + hero2.getHP() + " - Attack: " + hero2.getWeapon().getDamage() + System.lineSeparator() + "Mana: " + hero2.getMP() + "|" + hero2.getCurrentMP() + " - Mana Cost: " + hero2.getWeapon().getManaCost());
            }
            if (heroTeam.indexOf(hero2) == 2) {
                FightHeroName3.setVisible(true);
                FightHeroName3.setText(hero2.getName() + " the " + hero2.getClassHero() + System.lineSeparator() + "Health: " + hero2.getCurrentHP() + "|" + hero2.getHP() + " - Attack: " + hero2.getWeapon().getDamage() + System.lineSeparator() + "Mana: " + hero2.getMP() + "|" + hero2.getCurrentMP() + " - Mana Cost: " + hero2.getWeapon().getManaCost());
            }
            if (heroTeam.indexOf(hero2) == 3) {
                FightHeroName4.setVisible(true);
                FightHeroName4.setText(hero2.getName() + " the " + hero2.getClassHero() + System.lineSeparator() + "Health: " + hero2.getCurrentHP() + "|" + hero2.getHP() + " - Attack: " + hero2.getWeapon().getDamage() + System.lineSeparator() + "Mana: " + hero2.getMP() + "|" + hero2.getCurrentMP() + " - Mana Cost: " + hero2.getWeapon().getManaCost());
            }
        }
        for (Enemy enemy : enemyTeam) {
            if (enemyTeam.indexOf(enemy) == 0) {
                FightEnemyName1.setVisible(true);
                FightEnemyName1.setText(enemy.getName() + " the " + enemy.getEnemyClass() + System.lineSeparator() + "Health: " + enemy.getCurrentHealth() + "|" + enemy.getHealth() + " - Attack: " + enemy.getAttack());
            }
            if (enemyTeam.indexOf(enemy) == 1) {
                FightEnemyName2.setVisible(true);
                FightEnemyName2.setText(enemy.getName() + " the " + enemy.getEnemyClass() + System.lineSeparator() + "Health: " + enemy.getCurrentHealth() + "|" + enemy.getHealth() + " - Attack: " + enemy.getAttack());
            }
            if (enemyTeam.indexOf(enemy) == 2) {
                FightEnemyName3.setVisible(true);
                FightEnemyName3.setText(enemy.getName() + " the " + enemy.getEnemyClass() + System.lineSeparator() + "Health: " + enemy.getCurrentHealth() + "|" + enemy.getHealth() + " - Attack: " + enemy.getAttack());
            }
            if (enemyTeam.indexOf(enemy) == 3) {
                FightEnemyName4.setVisible(true);
                FightEnemyName4.setText(enemy.getName() + " the " + enemy.getEnemyClass() + System.lineSeparator() + "Health: " + enemy.getCurrentHealth() + "|" + enemy.getHealth() + " - Attack: " + enemy.getAttack());
            }
        }
        List<String> enemyList = new ArrayList<>();
        enemyList.add(enemyTeam.get(0).getName() + " the " + enemyTeam.get(0).getEnemyClass());
        if (enemyTeam.size() > 1) {
            enemyList.add(enemyTeam.get(1).getName() + " the " + enemyTeam.get(1).getEnemyClass());
        }
        if (enemyTeam.size() > 2) {
            enemyList.add(enemyTeam.get(2).getName() + " the " + enemyTeam.get(2).getEnemyClass());
        }
        if (enemyTeam.size() > 3) {
            enemyList.add(enemyTeam.get(3).getName() + " the " + enemyTeam.get(3).getEnemyClass());
        }
        ChoiceEnemyAttack.setItems(FXCollections.observableArrayList(enemyList));
        List<String> heroList = new ArrayList<>();
        heroList.add(heroTeam.get(0).getName() + " the " + heroTeam.get(0).getClassHero());
        if (heroTeam.size() > 1) {
            heroList.add(heroTeam.get(1).getName() + " the " + heroTeam.get(1).getClassHero());
        }
        if (heroTeam.size() > 2) {
            heroList.add(heroTeam.get(2).getName() + " the " + heroTeam.get(2).getClassHero());
        }
        if (heroTeam.size() > 3) {
            heroList.add(heroTeam.get(3).getName() + " the " + heroTeam.get(3).getClassHero());
        }
        ChoiceHeroHeal.setItems(FXCollections.observableArrayList(heroList));
        fightinterface();
    }
}
