package com.factoriaf5.kata;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CharacterTest {

    private Character character;
    private Character target;

    @BeforeEach
    public void setUp() {
        character = new Character();
        target = new Character();
    }

    @Test
    public void testDefaultHealth() {
        assertEquals(1000, character.getHealth());
    }

    @Test
    public void testDefaultLevel() {
        assertEquals(1, character.getLevel());
    }

    @Test
    public void testIsAliveByDefault() {
        assertTrue(character.isAlive());
    }

    @Test
    public void testDealDamageWithinLevelDifference() {
        character.dealDamage(target, 100);
        assertEquals(900, target.getHealth());
    }

    @Test
    public void testDealDamageHigherLevelTarget() {
        Character higherLevelTarget = new Character(6);
        character.dealDamage(higherLevelTarget, 100);
        assertEquals(950, higherLevelTarget.getHealth());
    }

    @Test
    public void testDealDamageLowerLevelTarget() {
        Character lowerLevelTarget = new Character(-4);
        character.dealDamage(lowerLevelTarget, 100);
        assertEquals(850, lowerLevelTarget.getHealth());
    }

    @Test
    public void testDealDamageToDeadCharacter() {
        character.dealDamage(target, 1000);
        assertEquals(0, target.getHealth());
        assertFalse(target.isAlive());
    }

    @Test
    public void testSelfHealWhenAlive() {
        target.dealDamage(character, 500);
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
        target.dealDamage(character, 1000);
        character.selfHeal(100);
        assertEquals(0, character.getHealth());
    }

    @Test
    public void testHealAnotherCharacter() {
        character.dealDamage(target, 500);
        character.heal(200, target);
        assertEquals(700, target.getHealth());
    }

    @Test
    public void testHealBeyondMaxHealth() {
        character.heal(200, character);
        assertEquals(1000, character.getHealth());
    }
}