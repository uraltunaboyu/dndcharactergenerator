package model;

import model.Constants.Dice;

import java.util.HashMap;

import static model.Constants.skillNames.*;
import static model.Constants.statNames.*;

public class Character {
    private String characterName;
    private Class characterClass;
    private Race characterRace;
    private int characterHealth;
    private int characterSpeed;
    private String characterAlignment;
    private Dice characterHitDie;
    private HashMap<Constants.statNames, Integer> characterStats;
    private HashMap<Constants.statNames, Boolean> statProficiencies;
    private HashMap<Constants.skillNames, Integer> characterSkills;
    private HashMap<Constants.skillNames, Boolean> skillProficiencies;
    public static HashMap<Constants.skillNames, Constants.statNames> skillStats;
    private int characterLevel;
    private int proficiencyBonus;

    public int getCharacterLevel() {
        return characterLevel;
    }

    public int getProficiencyBonus() {
        return proficiencyBonus;
    }

    private static void populateSkillStats() {
        skillStats.put(Acrobatics, Strength);
        skillStats.put(AnimalHandling, Wisdom);
        skillStats.put(Arcana, Intelligence);
        skillStats.put(Athletics, Strength);
        skillStats.put(Deception, Charisma);
        skillStats.put(History, Intelligence);
        skillStats.put(Insight, Wisdom);
        skillStats.put(Intimidation, Intelligence);
        skillStats.put(Investigation, Intelligence);
        skillStats.put(Medicine, Wisdom);
        skillStats.put(Nature, Intelligence);
        skillStats.put(Perception, Wisdom);
        skillStats.put(Performance, Charisma);
        skillStats.put(Persuasion, Charisma);
        skillStats.put(Religion, Intelligence);
        skillStats.put(SleightOfHand, Dexterity);
        skillStats.put(Stealth, Dexterity);
        skillStats.put(Survival, Wisdom);
    }

    private void populateStats(int[] stats) {
        characterStats.put(Strength, stats[0]);
        characterStats.put(Dexterity, stats[1]);
        characterStats.put(Constitution, stats[2]);
        characterStats.put(Intelligence, stats[3]);
        characterStats.put(Wisdom, stats[4]);
        characterStats.put(Charisma, stats[5]);

        statProficiencies.put(Strength, false);
        statProficiencies.put(Dexterity, false);
        statProficiencies.put(Constitution, false);
        statProficiencies.put(Intelligence, false);
        statProficiencies.put(Wisdom, false);
        statProficiencies.put(Charisma, false);
    }

    private void populateSkills() {
        characterSkills.put(Acrobatics, getStat(Strength) + ((hasProficiency(Strength)) ? proficiencyBonus : 0));
    }

    public void calculateSkill(Constants.skillNames skillName) {

    }

    public void setStat(Constants.statNames statName, int newStat) {
        characterStats.put(statName, newStat);
    }

    public int getStat(Constants.statNames statName) {
        return characterStats.get((statName));
    }

    public boolean hasProficiency(Constants.statNames statName) {
        return statProficiencies.get(statName);
    }

    public void setProficiency(Constants.statNames statName) {
        statProficiencies.put(statName, true);
    }

    public int getStatMod(Constants.statNames statName) {
        return (characterStats.get(statName) - 10) / 2;
    }

}

