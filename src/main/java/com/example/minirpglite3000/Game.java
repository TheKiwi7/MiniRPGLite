package com.example.minirpglite3000;


import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    public void ChooseHero(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("ChooseHeroTeam.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Choose your heroes !");
        stage.setScene(scene);
        stage.show();
    }

    public static int round = 0;
    public static int numHeroes=0;
    public int win = 0;
    public static String Hero1Name;
    public static String Hero2Name;
    public static String Hero3Name;
    public static String Hero4Name;
    public static String name;
    public static String Hero1Class;
    public static String Hero2Class;
    public static String Hero3Class;
    public static String Hero4Class;
    public static String type;
    public static int Hero1Weapon;
    public static int Hero2Weapon;
    public static int Hero3Weapon;
    public static int Hero4Weapon;
    public static int weapon;

    private static Scanner sc = new Scanner(System.in);
    
    public void MainMenu() {

        System.out.println("Welcome to MiniRPG Lite 3000!");
        System.out.println("Please select an option:");
        System.out.println("1. Start Game");
        System.out.println("2. Exit Game");




        int option = sc.nextInt();

        if (option == 1) {
            createHeroTeam();
        }
        else if (option == 2) {
            System.out.println("Thank you for playing!");
            System.exit(0);
        }
        else {
            System.out.println("Invalid option, please try again.");
            MainMenu();
        }

    }
    public static void createHeroTeam() {
        ArrayList<Hero> heroTeam = new ArrayList<Hero>();
        System.out.println("How many heroes do you want to create?");

        do {
            if (numHeroes ==0){
                numHeroes = sc.nextInt();
            }
            if ( numHeroes < 1 || numHeroes > 4) {
                System.out.println("You must create between 1 and 4 heroes.");
                createHeroTeam();
            } else {
                break;
            }
        } while (true);


        for (int i = 0; i < numHeroes; i++) {
            System.out.println("What is the name of hero " + (i + 1) + "?");
            //check if Hero1Name is null and if i = 0
            if (Hero1Name == null && i == 0){
                Hero1Name = sc.next();
            }
            else if (Hero2Name == null && i == 1){
                Hero2Name = sc.next();
            }
            else if (Hero3Name == null && i == 2){
                Hero3Name = sc.next();
            }
            else if (Hero4Name == null && i == 3){
                Hero4Name = sc.next();
            }
            System.out.println("What is the class of hero " + (i + 1) + "?");
            System.out.println("1. Warrior");
            System.out.println("2. Mage");
            System.out.println("3. Hunter");
            System.out.println("4. Healer");
            if (i == 0){
                if(Hero1Class == null){
                    type = sc.next();
                }
                else{
                    type = Hero1Class;
                }
            }
            else if (i == 1){
                if(Hero2Class == null){
                    type = sc.next();
                }
                else{
                    type = Hero2Class;
                }
            }
            else if (i == 2){
                if(Hero3Class == null){
                    type = sc.next();
                }
                else{
                    type = Hero3Class;
                }
            }
            else if (i == 3){
                if(Hero4Class == null){
                    type = sc.next();
                }
                else{
                    type = Hero4Class;
                }
            }
            if (type.equals("1")) {
                System.out.println("What is the weapon of hero " + (i + 1) + "?");
                System.out.println("1. Sword - Damage: 10 - Mana Cost: 10");
                System.out.println("2. Axe - Damage: 15 - Mana Cost: 15");
                System.out.println("3. Mace - Damage: 20 - Mana Cost: 20");
                System.out.println("4. Spear - Damage: 25 - Mana Cost: 25");
            } else if (type.equals("2")) {
                System.out.println("What is the weapon of hero " + (i + 1) + "?");
                System.out.println("1. Staff - Damage: 10 - Mana Cost: 20");
                System.out.println("2. Wand - Damage: 15 - Mana Cost: 30");
                System.out.println("3. Book - Damage: 20 - Mana Cost: 40");
                System.out.println("4. Orb - Damage: 25 - Mana Cost: 50");
            } else if (type.equals("3")) {
                System.out.println("What is the weapon of hero " + (i + 1) + "?");
                System.out.println("1. Bow - Damage: 10 - Mana Cost: 5");
                System.out.println("2. Crossbow - Damage: 15 - Mana Cost: 10");
                System.out.println("3. Rifle - Damage: 20 - Mana Cost: 15");
                System.out.println("4. Sniper - Damage: 25 - Mana Cost: 20");
            } else if (type.equals("4")) {
                System.out.println("What is the weapon of hero " + (i + 1) + "?");
                System.out.println("1. Staff - Damage: 10 - Mana Cost: 30");
                System.out.println("2. Wand - Damage: 15 - Mana Cost: 45");
                System.out.println("3. Book - Damage: 20 - Mana Cost: 60");
                System.out.println("4. Orb - Damage: 25 - Mana Cost: 75");
            } else {
                System.out.println("You must choose between Warrior, Mage, Hunter, Healer");
                createHeroTeam();
            }
            if (i == 0){
                if(Hero1Weapon == 0){
                    weapon = sc.nextInt();
                }
                else{
                    weapon = Hero1Weapon;
                }
            }
            else if (i == 1){
                if(Hero2Weapon == 0){
                    weapon = sc.nextInt();
                }
                else{
                    weapon = Hero2Weapon;
                }
            }
            else if (i == 2){
                if(Hero3Weapon == 0){
                    weapon = sc.nextInt();
                }
                else{
                    weapon = Hero3Weapon;
                }
            }
            else if (i == 3){
                if(Hero4Weapon == 0){
                    weapon = sc.nextInt();
                }
                else{
                    weapon = Hero4Weapon;
                }
            }
            if(i==0){
                if(Hero1Name == null){
                    name = sc.next();
                }
                else{
                    name = Hero1Name;
                }
            }
            else if(i==1){
                if(Hero2Name == null){
                    name = sc.next();
                }
                else{
                    name = Hero2Name;
                }
            }
            else if(i==2){
                if(Hero3Name == null){
                    name = sc.next();
                }
                else{
                    name = Hero3Name;
                }
            }
            else if(i==3){
                if(Hero4Name == null){
                    name = sc.next();
                }
                else{
                    name = Hero4Name;
                }
            }

            Hero hero = new Hero(name, type, weapon);
            heroTeam.add(hero);
            System.out.println();
        }
        System.out.println("Your team of heroes is:");
        for (Hero hero : heroTeam) {
            System.out.println(hero.getName() + " the " + hero.getClassHero()+ " with a "+ hero.getWeapon().getName());
        }
        System.out.println();
        createEnemyTeam(numHeroes, heroTeam);
    }
    /*public static void menu(ArrayList<Hero> heroTeam) {
        System.out.println("What do you want to do?");
        System.out.println("1. Start the Fight");
        System.out.println("2. Make a new team of heroes");
        System.out.println("3. Exit the game");
        int choice = sc.nextInt();
        if (choice == 1) {
            createEnemyTeam(numHeroes, heroTeam);
        } else if (choice == 2) {
            createHeroTeam();
        } else if (choice == 3) {
            System.exit(0);
        } else {
            System.out.println("You must choose between 1, 2, or 3");
            menu(heroTeam);
        }
    }*/
    public static void createEnemyTeam(int numHeroes, ArrayList<Hero> heroTeam) {
        ArrayList<Enemy> enemyTeam = new ArrayList<Enemy>();
        if (round < 4) {


            for (int i = 0; i < numHeroes; i++) {
                Enemy enemy = new Enemy();
                enemyTeam.add(enemy);
            }
            System.out.println("The team of ennemies is:");
            for (Enemy enemy : enemyTeam) {
                System.out.println(enemy.getName() + " the " + enemy.getEnemyClass() + " - Health: " + enemy.getHealth() + " - Attack: " + enemy.getAttack());
            }
            System.out.println();
            round++;
        } else {
            Enemy enemy = new Enemy();
            enemyTeam.add(enemy);
            System.out.println("You encounter the final boss: ");
            System.out.println(enemy.getName() + " the " + enemy.getEnemyClass() + " - Health: " + enemy.getHealth() + " - Attack: " + enemy.getAttack());
        }
        fight(heroTeam,enemyTeam);

    }


    public static void fight(ArrayList<Hero> heroTeam, ArrayList<Enemy> enemyTeam) {
        for (Hero hero : heroTeam) {
            System.out.println("It's " + hero.getName() + " the " + hero.getClassHero() + "'s turn" );
            for (Hero hero2 : heroTeam) {
                System.out.println(hero2.getName()+ " the "+ hero2.getClassHero()+ " as : " + hero2.getCurrentHP()+"|"+hero2.getHP()+" HP and " + hero2.getCurrentMP()+"|"+hero2.getMP()+ " MP");
            }
            System.out.println();
            System.out.println("What do you want to do?");
            System.out.println("1. Attack for " + hero.getWeapon().getDamage() + " damage");
            System.out.println("2. Special Attack (Mana Cost: " + hero.getWeapon().getManaCost() + ")");
            System.out.println("3. Wait : Restores 20% of your Mana");
            if (hero.getCapsule() > 0) {
                System.out.println("4. Use a capsule (Heals your whole team for 30 HP)");
            }
            int choice = sc.nextInt();
            if (choice == 1) {
                System.out.println("Which enemy do you want to attack?");
                for (Enemy enemy : enemyTeam) {
                    int index = enemyTeam.indexOf(enemy);
                    System.out.println(index+1 +". "+enemy.getName() +" the "+enemy.getEnemyClass()+ " - HP: " + enemy.getCurrentHealth() + " | " + enemy.getHealth() + " - Attack: " + enemy.getAttack());
                }
                int enemyChoice = sc.nextInt() - 1;
                Enemy enemy = enemyTeam.get(enemyChoice);
                attack(enemy, hero, enemyTeam, heroTeam);
            } else if (choice == 2) {
                if (hero.getCurrentMP() >= hero.getWeapon().getManaCost()) {
                    specialAttack(hero, heroTeam, enemyTeam);
                }
                else {
                    System.out.println("You don't have enough mana to use this attack");
                }
            } else if (choice == 3) {
                int current = hero.getCurrentMP();
                hero.setCurrentMP((int) ( hero.getCurrentMP() + Math.round(hero.getMP()*0.2)));
                if (hero.getCurrentMP() > hero.getMP()) {
                    hero.setCurrentMP(hero.getMP());
                }
                int difference = hero.getCurrentMP()-current;
                System.out.println(hero.getName() + " regenerated " + difference + "MP");
            } else if (choice == 4) {
                if (hero.getCapsule() > 0) {
                    for (Hero hero4 : heroTeam) {
                        int current = hero4.getCurrentHP();
                        hero4.setCurrentHP(hero4.getCurrentHP() + 30);
                        if (hero4.getCurrentHP() > hero4.getHP()) {
                            hero4.setCurrentHP(hero4.getHP());
                        }
                        int difference = hero4.getCurrentHP()-current;
                        System.out.println(hero4.getName() + " was healed for " + difference + "HP");
                    }
                    hero.setCapsule(hero.getCapsule()-1);
                }
                else {
                    System.out.println("You don't have any capsule");
                }
            } else {
                System.out.println("You must choose between 1, 2, 3 or 4");
                fight(heroTeam, enemyTeam);
            }
            int index = heroTeam.indexOf(hero);
            if (index == heroTeam.size()-1) {
                for (Enemy enemy : enemyTeam) {
                    enemyAttack(enemy, heroTeam);
                    fight(heroTeam,enemyTeam);
                }
            }

        }

    }
    public static void attack(Enemy enemy, Hero hero, ArrayList<Enemy> enemyTeam, ArrayList<Hero> heroTeam) {
        enemy.setCurrentHealth(enemy.getCurrentHealth() - hero.getWeapon().getDamage());
        System.out.println(hero.getName() + " attacked " +enemy.getName() +" the "+enemy.getEnemyClass()+ " for " + hero.getWeapon().getDamage() + " damage");
        if (enemy.getCurrentHealth() <= 0) {
            System.out.println(enemy.getName() +" the "+enemy.getEnemyClass()+ " is dead");
            enemyTeam.remove(enemy);
        }
        if (enemyTeam.size() == 0) {
            System.out.println("You won the fight");
            if (round == 4) {
                System.out.println("Good job you cleared the game !");
                System.exit(0);
            }
            else{
                for (Hero hero3 : heroTeam) {
                    System.out.println("What bonus do you want to give to " + hero3.getName() + " the "+ hero3.getClassHero()+"?");
                    System.out.println("1. +10 HP");
                    System.out.println("2. +10 MP");
                    System.out.println("3. A healing capsule (Heals your whole team for 30 HP)");
                    int bonusChoice = sc.nextInt();
                    if (bonusChoice == 1){
                        System.out.println("You gave +10 HP to " + hero3.getName() + " the "+ hero3.getClassHero());
                        hero3.setHP(hero3.getHP()+10);
                    }
                    else if (bonusChoice == 2){
                        System.out.println("You gave +10 MP to " + hero3.getName() + " the "+ hero3.getClassHero());
                        hero3.setMP(hero3.getMP()+10);
                    }
                    else if (bonusChoice == 3){
                        hero.setCapsule(hero.getCapsule()+1);
                        System.out.println("You have " + hero.getCapsule() + " capsules with "+ hero3.getName() + " the "+ hero3.getClassHero());
                    }
                    else {
                        System.out.println("You must choose between 1, 2, or 3 ... You get nothing");
                    }
                    hero3.setCurrentHP(hero3.getHP());
                    hero3.setCurrentMP(hero3.getMP());

                }
                createEnemyTeam(numHeroes, heroTeam);
            }

        }
    }

    public static void specialAttack(Hero hero, ArrayList<Hero> heroTeam, ArrayList<Enemy> enemyTeam){
        hero.setCurrentMP(hero.getCurrentMP()- hero.getWeapon().getManaCost());
        if (hero.getClassHero().equals("Healer")){
            System.out.println("Which hero do you want to heal?");
            for (Hero hero2 : heroTeam) {
                int index = heroTeam.indexOf(hero2);
                System.out.println(index +1 +". "+hero2.getName() + " - Health: " + hero2.getCurrentHP() + "|"+ hero2.getHP());
            }
            int heroChoice = sc.nextInt() - 1;
            Hero hero2 = heroTeam.get(heroChoice);
            int current = hero2.getCurrentHP();
            hero2.setCurrentHP(hero2.getCurrentHP() + 50);
            if (hero2.getCurrentHP() > hero2.getHP()){
                hero2.setCurrentHP(hero2.getHP());
            }
            int difference = hero.getCurrentHP() - current;
            System.out.println(hero.getName() + " was healed for " + difference + "MP");
        }
        else {
            System.out.println("Which enemy do you want to attack?");
            for (Enemy enemy : enemyTeam) {
                int index = enemyTeam.indexOf(enemy);
                System.out.println(index+1 +". "+enemy.getName() +" the "+enemy.getEnemyClass()+ " - HP: " + enemy.getCurrentHealth() + " | " + enemy.getHealth() + " - Attack: " + enemy.getAttack());
            }
            int enemyChoice = sc.nextInt() - 1;
            Enemy enemy = enemyTeam.get(enemyChoice);
            enemy.setCurrentHealth(enemy.getCurrentHealth() - hero.getWeapon().getDamage()*2);
            System.out.println(hero.getName() + " destroyed " +enemy.getName() +" the "+enemy.getEnemyClass()+" for " + hero.getWeapon().getDamage()*2 + " damage");
            if (enemy.getCurrentHealth() <= 0) {
                System.out.println(enemy.getName() +" the "+enemy.getEnemyClass()+ " is dead");
                enemyTeam.remove(enemy);
            }
            if (enemyTeam.size() == 0) {
                System.out.println("You won the fight");
                if (round == 5) {
                    System.out.println("Good job you cleared the game !");
                    System.exit(0);
                }
                else{
                    for (Hero hero3 : heroTeam) {
                        System.out.println("What bonus do you want to give to " + hero3.getName() + " the "+ hero3.getClassHero()+"?");
                        System.out.println("1. +10 HP");
                        System.out.println("2. +10 MP");
                        System.out.println("3. A healing capsule (Heals your whole team for 30 HP)");
                        int bonusChoice = sc.nextInt();
                        if (bonusChoice == 1){
                            hero3.setHP(hero3.getHP()+10);
                            System.out.println("You gave +10 HP to " + hero3.getName() + " the "+ hero3.getClassHero());
                        }
                        else if (bonusChoice == 2){
                            hero3.setMP(hero3.getMP()+10);
                            System.out.println("You gave +10 MP to " + hero3.getName() + " the "+ hero3.getClassHero());
                        }
                        else if (bonusChoice == 3){
                            hero.setCapsule(hero.getCapsule()+1);
                            System.out.println("You have " + hero.getCapsule() + " capsules with "+ hero3.getName() + " the "+ hero3.getClassHero());
                        }
                        else {
                            System.out.println("You must choose between 1, 2, or 3 ... You get nothing");
                        }
                        hero3.setCurrentHP(hero3.getHP());
                        hero3.setCurrentMP(hero3.getMP());

                    }
                    createEnemyTeam(numHeroes, heroTeam);
                }

            }
        }


    }
    public static void enemyAttack(Enemy enemy, ArrayList<Hero> heroTeam)
    {
            if (round < 4) {
                int index = (int) (Math.random() * heroTeam.size());
                while (heroTeam.get(index).getCurrentHP() <= 0) {
                    index = (int) (Math.random() * heroTeam.size());
                }
                Hero hero = heroTeam.get(index);
                hero.setCurrentHP(hero.getCurrentHP() - enemy.getAttack());
                System.out.println(enemy.getName() + " the " + enemy.getEnemyClass() + " attacked " + hero.getName() + " for " + enemy.getAttack() + " damage");
                if (hero.getCurrentHP() <= 0) {
                    System.out.println(hero.getName() + " is dead");
                    heroTeam.remove(hero);
                }
                if (heroTeam.size() == 0) {
                    System.out.println("You lost the fight");
                    System.exit(0);
                }
            }
            else {
                for (Hero hero2 : heroTeam) {
                    hero2.setCurrentHP(hero2.getCurrentHP() - enemy.getAttack());
                    System.out.println(enemy.getName() + " the " + enemy.getEnemyClass() + " attacked " + hero2.getName() + " for " + enemy.getAttack() + " damage");
                    if (hero2.getCurrentHP() <= 0) {
                        System.out.println(hero2.getName() + " is dead");
                        heroTeam.remove(hero2);
                    }
                    if (heroTeam.size() == 0) {
                        System.out.println("You lost the fight");
                        System.exit(0);
                    }
                }
            }

    }
}
