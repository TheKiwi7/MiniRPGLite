package com.example.minirpglite3000;

public class Weapon {

    // Constructor for the Weapon with Damage, Mana Cost and Name as parameters corresponding to the Weapon class

    public Weapon(int damage, int manaCost, String name) {
        this.Damage = damage;
        this.ManaCost = manaCost;
        this.Name = name;
    }

    // Getters and setters for the Weapon class

    public int getDamage() {
        return Damage;
    }

    public void setDamage(int Damage) {
        this.Damage = Damage;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getManaCost() {
        return ManaCost;
    }

    public void setManaCost(int ManaCost) {
        this.ManaCost = ManaCost;
    }


    private int Damage;

    private String Name;

    private int ManaCost;

}
