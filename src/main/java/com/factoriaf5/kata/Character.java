package com.factoriaf5.kata;

public class Character {
    private int health;
    private int level;
    private boolean isAlive;

    public Character() {
        this.health = 1000;
        this.level = 1;
        this.isAlive = true;
    }

    public int getHealth() {
        return health;
    }

    public int getLevel() {
        return level;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void dealDamage(Character target, int damageAmount) {
        if (!target.isAlive) {
            return;
        }
        target.health -= damageAmount;
        if (target.health <= 0) {
            target.health = 0;
            target.isAlive = false;
        }
    }

    public void heal(int healAmount) {
        if (!isAlive) {
            return;
        }
        health = Math.min(health + healAmount, 1000);
    }
}
