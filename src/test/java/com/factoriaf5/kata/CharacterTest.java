package com.factoriaf5.kata;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CharacterTest {

    private Character character;
    private Character target;

    @BeforeEach
    public void setUp() {
        character = new Character(0, Character.CharacterClass.Melee);
        target = new Character(0, Character.CharacterClass.Ranged);
    }

    @Test
    public void testDefaultHealth() {
        assertEquals(1000, character.getHealth());
    }

    @Test
    public void testIsAliveByDefault() {
        assertTrue(character.isAlive());
    }

    @Test
    public void testDealDamageWithinLevelDifference() {
        character.dealDamage(target, 100, 1);
        assertEquals(900, target.getHealth());
    }

    @Test
    public void testDealDamageHigherLevelTarget() {
        Character higherLevelTarget = new Character(7, Character.CharacterClass.Melee);
        character.dealDamage(higherLevelTarget, 100, 1);
        assertEquals(950, higherLevelTarget.getHealth());
    }

    @Test
    public void testDealDamageLowerLevelTarget() {
        Character lowerLevelTarget = new Character(-5, Character.CharacterClass.Melee);
        character.dealDamage(lowerLevelTarget, 100, 1);
        assertEquals(850, lowerLevelTarget.getHealth());
    }

    @Test
    public void testDealDamageToDeadCharacter() {
        character.dealDamage(target, 1000, 1);
        assertEquals(0, target.getHealth());
        assertFalse(target.isAlive());
    }

    @Test
    public void testSelfHealWhenAlive() {
        target.dealDamage(character, 500, 1);
        character.selfHeal(300);
        assertEquals(800, character.getHealth());
    }

    @Test
    public void testSelfHealWhenHealthIsMax() {
        character.selfHeal(100);
        assertEquals(1000, character.getHealth());
    }

    @Test
    public void testSelfHealWhenDead() {
        target.dealDamage(character, 1000, 1);
        character.selfHeal(100);
        assertEquals(0, character.getHealth());
    }

    @Test
    public void testHealAnotherCharacter() {
        character.dealDamage(target, 500, 1);
        character.heal(200, target);
        assertEquals(700, target.getHealth());
    }

    @Test
    public void testHealBeyondMaxHealth() {
        character.heal(200, character);
        assertEquals(1000, character.getHealth());
    }

    @Test
    public void testCharacterClassAndRange() {
        Character meleeCharacter = new Character(1, Character.CharacterClass.Melee);
        assertEquals(2, meleeCharacter.getRange());

        Character rangedCharacter = new Character(1, Character.CharacterClass.Ranged);
        assertEquals(20, rangedCharacter.getRange());
    }

    @Test
    public void testDealDamageOutOfRange() {
        Character target = new Character(1, Character.CharacterClass.Melee);
        character.dealDamage(target, 100, 3);
        assertEquals(1000, target.getHealth());
    }

    @Test
    public void testDealDamageInRange() {
        Character target = new Character(1, Character.CharacterClass.Melee);
        character = new Character(1, Character.CharacterClass.Ranged);
        character.dealDamage(target, 100, 20);
        assertEquals(900, target.getHealth());
    }

}