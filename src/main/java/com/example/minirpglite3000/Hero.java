package com.example.minirpglite3000;

public class Hero {

    private int HP;
    private int currentHP;
    private int MP;
    private int currentMP;
    private Weapon Weapon;
    private String ClassHero;
    private String Name;
    private int Capsule;

    public Hero(String name, String type, int weapon) {
        this.Name = name;
        if (type.equals("1")) {
            this.ClassHero = "Warrior";
        } else if (type.equals("2")) {
            this.ClassHero = "Mage";
        } else if (type.equals("3")) {
            this.ClassHero = "Hunter";
        } else if (type.equals("4")) {
            this.ClassHero = "Healer";
        }
        if (ClassHero.equals("Warrior")) {
            this.HP = 200;
            this.MP = 50;
            if (weapon == 1) {
                this.Weapon = new Weapon(10, 10, "Sword");
            } else if (weapon == 2) {
                this.Weapon = new Weapon(15, 15, "Axe");
            } else if (weapon == 3) {
                this.Weapon = new Weapon(20, 20, "Mace");
            } else if (weapon == 4) {
                this.Weapon = new Weapon(25, 25, "Spear");
            } else {
                System.out.println("You didn't choose a weapon ...  you get nothing, you deserved it.");
                this.Weapon = new Weapon(3, 40, "Fists");
            }
        } else if (ClassHero.equals("Mage")) {
            this.HP = 75;
            this.MP = 200;
            if (weapon == 1) {
                this.Weapon = new Weapon(15, 20, "Staff");
            } else if (weapon == 2) {
                this.Weapon = new Weapon(20, 30, "Wand");
            } else if (weapon == 3) {
                this.Weapon = new Weapon(25, 40, "Book");
            } else if (weapon == 4) {
                this.Weapon = new Weapon(30, 50, "Orb");
            } else {
                System.out.println("You didn't choose a weapon ...  you get nothing, you deserved it.");
                this.Weapon = new Weapon(3, 40, "Fists");
            }
        } else if (ClassHero.equals("Hunter")) {
            this.HP = 125;
            this.MP = 100;
            if (weapon == 1) {
                this.Weapon = new Weapon(8, 5, "Bow");
            } else if (weapon == 2) {
                this.Weapon = new Weapon(12, 10, "Crossbow");
            } else if (weapon == 3) {
                this.Weapon = new Weapon(16, 15, "Gun");
            } else if (weapon == 4) {
                this.Weapon = new Weapon(20, 20, "Rifle");
            } else {
                System.out.println("You didn't choose a weapon ...  you get nothing, you deserved it.");
                this.Weapon = new Weapon(3, 40, "Fists");
            }
        } else if (ClassHero.equals("Healer")) {
            this.HP = 150;
            this.MP = 300;
            if (weapon == 1) {
                this.Weapon = new Weapon(3, 30 , "Staff");
            } else if (weapon == 2) {
                this.Weapon = new Weapon(6, 45, "Wand");
            } else if (weapon == 3) {
                this.Weapon = new Weapon(9, 60, "Book");
            } else if (weapon == 4) {
                this.Weapon = new Weapon(12, 75, "Orb");
            } else {
                System.out.println("You didn't choose a weapon ...  you get nothing, you deserved it.");
                this.Weapon = new Weapon(3, 40, "Fists");
            }
        }
        this.currentHP = this.HP;
        this.currentMP = this.MP;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getMP() {
        return MP;
    }

    public void setMP(int MP) {
        this.MP = MP;
    }

    public Weapon getWeapon() {
        return Weapon;
    }

    public void setWeapon(Weapon Weapon) {
        this.Weapon = Weapon;
    }

    public String getClassHero() {
        return ClassHero;
    }

    public void setClass(String Class) {
        this.ClassHero = ClassHero;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getCurrentHP() {
        return currentHP;
    }

    public void setCurrentHP(int currentHP) {
        this.currentHP = currentHP;
    }

    public int getCurrentMP() {
        return currentMP;
    }

    public void setCurrentMP(int currentMP) {
        this.currentMP = currentMP;
    }

    public int getCapsule() {
        return Capsule;
    }

    public void setCapsule(int Capsule) {
        this.Capsule = Capsule;
    }


}
