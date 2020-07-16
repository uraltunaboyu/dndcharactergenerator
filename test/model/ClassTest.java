package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static model.Constants.Armor.*;
import static model.Constants.Weapons.Martial;
import static model.Constants.Weapons.Simple;
import static model.Constants.skillNames.*;
import static model.Constants.statNames.Charisma;
import static model.Constants.statNames.Wisdom;
import static org.junit.jupiter.api.Assertions.*;

public class ClassTest {

    Class testClass;
    Constants.statNames[] profStats = new Constants.statNames[]{Wisdom, Charisma};
    Constants.skillNames[] profSkills = new Constants.skillNames[] {Athletics, Insight, Intimidation, Medicine, Persuasion, Intimidation};

    @BeforeEach
    public void setup() {
        testClass = new Class("Paladin", profSkills, profStats, Constants.Dice.d10, new Constants.Armor[]{Light, Medium, Heavy, Shield},
                new Constants.Weapons[] {Simple, Martial});
    }

    @Test
    public void testGetters() {
        assertEquals(Constants.Dice.d10, testClass.getHitDie());
        assertEquals(profStats, testClass.getStatProficiencies());
    }

    @Test
    public void testRandomStatProfs() {
        Constants.skillNames[] returnedRandomSkillProfs = testClass.getRandomSkillProficiencies();
        assertEquals(2, returnedRandomSkillProfs.length);
        assertTrue(returnedRandomSkillProfs[0] != returnedRandomSkillProfs[1]);
    }
}
