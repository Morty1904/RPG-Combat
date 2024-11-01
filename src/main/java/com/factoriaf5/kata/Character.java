package com.factoriaf5.kata;

public class Character {
    private int health;
    private int level;
    private boolean isAlive;
    private int range;
    private CharacterClass characterClass;

    public enum CharacterClass {
        Melee(2), Ranged(20);

        private final int range;

        CharacterClass(int range) {
            this.range = range;
        }

        public int getRange() {
            return range;
        }
    }

    public Character(int level, CharacterClass characterClass) {
        this.health = 1000;
        this.level = level;
        this.isAlive = true;
        this.characterClass = characterClass;
        this.range = characterClass.getRange();
    }

    public int getRange() {
        return range;
    }

    public CharacterClass getCharacterClass() {
        return characterClass;
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

    public void dealDamage(Character target, int damageAmount, int distance) {
        if (!target.isAlive || target == this) {
            return;
        }

        if (distance > this.range) {
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