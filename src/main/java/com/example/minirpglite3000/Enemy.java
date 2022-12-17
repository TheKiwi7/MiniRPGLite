package com.example.minirpglite3000;

public class Enemy {

    private String Name;
    private int Health;
    private int currentHealth;
    private int Attack;

    private String Class;

    public Enemy() {

        if (Game.round < 4) {

            int random = (int) (Math.random() * 5);

            if (random == 0) {
                this.Class = "Goblin";
            } else if (random == 1) {
                this.Class = "Skeleton";
            } else if (random == 2) {
                this.Class = "Zombie";
            } else if (random == 3) {
                this.Class = "Troll";
            } else if (random == 4) {
                this.Class = "Spider";
            } else {
                this.Class = "Orc";
            }

            int randomName = (int) (Math.random() * 20);

            if (randomName == 0) {
                this.Name = "Greg";
            } else if (randomName == 1) {
                this.Name = "Mike";
            } else if (randomName == 2) {
                this.Name = "Louis";
            } else if (randomName == 3) {
                this.Name = "Morgan";
            } else if (randomName == 4) {
                this.Name = "John";
            } else if (randomName == 5) {
                this.Name = "James";
            } else if (randomName == 6) {
                this.Name = "Robert";
            } else if (randomName == 7) {
                this.Name = "Thomas";
            } else if (randomName == 8) {
                this.Name = "William";
            } else if (randomName == 9) {
                this.Name = "Richard";
            } else if (randomName == 10) {
                this.Name = "Charles";
            } else if (randomName == 11) {
                this.Name = "Joseph";
            } else if (randomName == 12) {
                this.Name = "David";
            } else if (randomName == 13) {
                this.Name = "Mary";
            } else if (randomName == 14) {
                this.Name = "Patricia";
            } else if (randomName == 15) {
                this.Name = "Jennifer";
            } else if (randomName == 16) {
                this.Name = "Linda";
            } else if (randomName == 17) {
                this.Name = "Elizabeth";
            } else if (randomName == 18) {
                this.Name = "Barbara";
            } else if (randomName == 19) {
                this.Name = "Susan";
            } else {
                this.Name = "Jessica";
            }



            this.Health = (int) ((1 + Game.round * 0.6) * (Math.round(Math.random() * 30) + 50));
            this.Attack = (int) ((1 + Game.round * 0.6) * (Math.round(Math.random() * 10) + 7));
        }
        else {
            this.Name = "Alduin";
            this.Class = "Dragon";
            this.Health = 800;
            this.Attack = 40;

        }
    }
        public String getName () {
            return Name;
        }
        public void setName (String Name){
            this.Name = Name;
        }
        public int getHealth () {
            return Health;
        }
        public void setHealth ( int Health){
            this.Health = Health;
        }
        public int getAttack () {
            return Attack;
        }
        public void setAttack ( int Attack){
            this.Attack = Attack;
        }

        public int getCurrentHealth () {
            return currentHealth;
        }

        public void setCurrentHealth ( int currentHealth){
            this.currentHealth = currentHealth;
        }

        public String getEnemyClass () {
            return Class;
        }

        public void setEnemyClass (String Class){
            this.Class = Class;
        }
    }

