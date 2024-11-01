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

    public Character(int level) {
        this.health = 1000;
        this.level = level;
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
        if (!target.isAlive || target == this) {
            return;
        }

        if (target.level >= this.level + 5) {
            damageAmount /= 2;
        } else if (target.level <= this.level - 5) {
            damageAmount = (int) (damageAmount * 1.5);
        }
        target.health -= damageAmount;
        if (target.health <= 0) {
            target.isAlive = false;
        }
    }

    public void heal(int healAmount, Character target) {
        if (!target.isAlive) {
            return;
        }
        target.health = Math.min(target.health + healAmount, 1000);
    }

    public void selfHeal(int healAmount) {
        if (!this.isAlive) {
            return;
        }
        this.health = Math.min(this.health + healAmount, 1000);
    }
}