package model;

import model.Constants.DICE;

import java.util.HashMap;

import static model.Constants.SKILL_NAMES.*;
import static model.Constants.STAT_NAMES.*;

public class Character {
    private String characterName;
    private Class characterClass;
    private Race characterRace;
    private int characterHealth;
    private int characterSpeed;
    private String characterAlignment;
    private DICE characterHitDie;
    private HashMap<Constants.STAT_NAMES, Integer> characterStats;
    private HashMap<Constants.STAT_NAMES, Boolean> statProficiencies;
    private HashMap<Constants.SKILL_NAMES, Integer> characterSkills;
    private HashMap<Constants.SKILL_NAMES, Boolean> skillProficiencies;
    public static HashMap<Constants.SKILL_NAMES, Constants.STAT_NAMES> skillStats;
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

    public void calculateSkill(Constants.SKILL_NAMES skillName) {

    }

    public void setStat(Constants.STAT_NAMES statName, int newStat) {
        characterStats.put(statName, newStat);
    }

    public int getStat(Constants.STAT_NAMES statName) {
        return characterStats.get((statName));
    }

    public boolean hasProficiency(Constants.STAT_NAMES statName) {
        return statProficiencies.get(statName);
    }

    public void setProficiency(Constants.STAT_NAMES statName) {
        statProficiencies.put(statName, true);
    }

    public int getStatMod(Constants.STAT_NAMES statName) {
        return (characterStats.get(statName) - 10) / 2;
    }

}

