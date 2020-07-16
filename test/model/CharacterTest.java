package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static model.Constants.Armor.*;
import static model.Constants.Armor.Shield;
import static model.Constants.StandardLanguages.Common;
import static model.Constants.StandardLanguages.Dwarvish;
import static model.Constants.Tools.*;
import static model.Constants.Weapons.Martial;
import static model.Constants.Weapons.Simple;
import static model.Constants.skillNames.*;
import static model.Constants.skillNames.Intimidation;
import static model.Constants.statNames.Charisma;
import static model.Constants.statNames.Wisdom;
import static org.junit.jupiter.api.Assertions.*;

public class CharacterTest {
    CharacterFactory characterFactoryTest;
    Character characterTest;
    Class testClass;
    Race testRace;

    @BeforeEach
    public void setup() {
        characterFactoryTest =  new CharacterFactory();
        testClass = new Class("testClass", new Constants.skillNames[] {Athletics, Insight, Intimidation, Medicine, Persuasion, Intimidation},
                new Constants.statNames[] {Wisdom, Charisma}, Constants.Dice.d10, new Constants.Armor[]{Light, Medium, Heavy, Shield},
                new Constants.Weapons[] {Simple, Martial});
        testRace = new Race("Dwarf", new String[] {"test1", "test2"}, new String[] {"test3", "test4"},
                new Constants.StandardLanguages[]{Common, Dwarvish}, new Constants.ExoticLanguages[0],
                new Constants.Tools[] {SmithTools, BrewerSupplies, MasonTools}, new int[]{0,0,2,0,0,0}, 25);
        characterFactoryTest.addToClasses(testClass);
        characterFactoryTest.addToRaces(testRace);
    }

    @Test
    public void characterBuildTest() {
        characterTest = characterFactoryTest.build();
        assertNotNull(characterTest.getCharacterName());
        assertNotNull(characterTest.getCharacterClass());
        assertNotNull(characterTest.getCharacterAlignment());
    }

    @Test
    public void characterStatsTest() {
        characterTest = characterFactoryTest.build();
        for(Constants.statNames stat: Constants.statNames.values()) {
            assertFalse(characterTest.getStat(stat) == -1);
        }
    }

    @Test
    public void characterProfsTest() {
        Constants.statNames[] classStatProfs = testClass.getStatProficiencies();
        characterTest = characterFactoryTest.build();
        for (Constants.statNames profStat : classStatProfs) {
            assertTrue(characterTest.hasStatProficiency(profStat));
        }
    }

}
