package com.factoriaf5.kata;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CharacterTest {

    @Test
    public void ExampleTest() {
        assertEquals(2, 2);
    }

    @Test
    public void testCharacterInitialization() {
        Character character = new Character();
        assertEquals(1000, character.getHealth(), "Health should start at 1000");
        assertEquals(1, character.getLevel(), "Level should start at 1");
        assertTrue(character.isAlive(), "Character should start alive");
    }

    @Test
    public void testDealDamageReducesHealth() {
        Character attacker = new Character();
        Character target = new Character();
        attacker.dealDamage(target, 200);
        assertEquals(800, target.getHealth(), "Health should be reduced by damage amount");
    }

    @Test
    public void testDealDamageKillsCharacter() {
        Character attacker = new Character();
        Character target = new Character();
        attacker.dealDamage(target, 1200);
        assertEquals(0, target.getHealth(), "Health should be 0 when damage exceeds health");
        assertFalse(target.isAlive(), "Character should be dead if health is 0");
    }

    @Test
    public void testHealingIncreasesHealth() {
        Character character = new Character();
        character.dealDamage(character, 500);
        character.heal(200);
        assertEquals(700, character.getHealth(), "Health should increase with healing");
    }

    @Test
    public void testHealingDoesNotExceedMaxHealth() {
        Character character = new Character();
        character.heal(500);
        assertEquals(1000, character.getHealth(), "Health should not exceed 1000");
    }

    @Test
    public void testDeadCharacterCannotBeHealed() {
        Character character = new Character();
        character.dealDamage(character, 1200);
        character.heal(200);
        assertEquals(0, character.getHealth(), "Dead character should not be healed");
    }
}
