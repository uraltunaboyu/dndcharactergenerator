package model;

import model.Constants.Dice;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Character {
    private String characterName;
    private Class characterClass;
    private Race characterRace;
    private int characterHealth;
    private int characterSpeed;
    private String characterAlignment;
    private Dice characterHitDie;
    private HashMap<Constants.statNames, Integer> characterStats = new LinkedHashMap<>();
    private HashMap<Constants.statNames, Boolean> statProficiencies = new LinkedHashMap<>();
    private HashMap<Constants.skillNames, Integer> characterSkills = new LinkedHashMap<>();
    private HashMap<Constants.skillNames, Boolean> skillProficiencies = new LinkedHashMap<>();
    public static Map<Constants.skillNames, Constants.statNames> skillStats = Constants.skillStats;
    private int characterLevel;
    private int proficiencyBonus;

    public Character(String characterName, Class characterClass, Race characterRace, String characterAlignment,
                     Dice characterHitDie, int[] stats, boolean[] statProficiencies, boolean[] skillProficiencies,
                     int characterLevel) {
        this.characterName = characterName;
        this.characterClass = characterClass;
        this.characterRace = characterRace;
        this.characterAlignment = characterAlignment;
        this.characterHitDie = characterHitDie;
        this.characterLevel = characterLevel;
        populateStats(stats);
        populateSkills();
        populateStatProficiencies(statProficiencies);
        populateSkillProficiencies(skillProficiencies);
    }

    public int getCharacterLevel() {
        return characterLevel;
    }

    public int getProficiencyBonus() {
        return proficiencyBonus;
    }


    private void populateStats(int[] stats) {
        int i = 0;
        for(Constants.statNames stat : Constants.statNames.values()) {
            characterStats.put(stat, stats[i]);
            i++;
        }

        for (Constants.statNames stat: Constants.statNames.values()) {
            statProficiencies.put(stat, false);
        }
    }

    private void populateSkills() {
        for (Map.Entry<Constants.skillNames, Constants.statNames> statSkillEntry: skillStats.entrySet()) {
            Constants.skillNames skill = statSkillEntry.getKey();
            Constants.statNames stat = statSkillEntry.getValue();
            int skillLevel = getStat(stat) + (hasStatProficiency(stat)?  proficiencyBonus : 0);
            characterSkills.put(skill, skillLevel);
        }
    }

    private void populateSkillProficiencies(boolean[] proficiencies) {
        int i = 0;
        for(Constants.skillNames skill: skillStats.keySet()) {
            skillProficiencies.put(skill, proficiencies[i]);
            i++;
        }
    }

    private void populateStatProficiencies(boolean[] proficiencies) {
        int i = 0;
        for(Constants.statNames stat: characterStats.keySet()) {
            statProficiencies.put(stat, proficiencies[i]);
            i++;
        }
    }

    public int calculateSkill(Constants.skillNames skillName) {
        return characterSkills.get(skillName);
    }

    public void setStat(Constants.statNames statName, int newStat) {
        characterStats.put(statName, newStat);
    }

    public void increaseStat(Constants.statNames statName, int increase) {
        int oldValue = characterStats.get(statName);
        characterStats.put(statName, oldValue + increase);
    }

    public int getStat(Constants.statNames statName) {
        return characterStats.get((statName));
    }

    public boolean hasStatProficiency(Constants.statNames statName) {
        return statProficiencies.get(statName);
    }

    public boolean hasSkillProficiency(Constants.skillNames skillName) {
        return skillProficiencies.get(skillName);
    }

    public void setStatProficiency(Constants.statNames statName) {
        statProficiencies.put(statName, true);
    }

    public int getStatMod(Constants.statNames statName) {
        return (characterStats.get(statName) - 10) / 2;
    }

    public String getCharacterName() {
        return characterName;
    }

    public Class getCharacterClass() {
        return characterClass;
    }

    public Race getCharacterRace() {
        return characterRace;
    }

    public int getCharacterHealth() {
        return characterHealth;
    }

    public int getCharacterSpeed() {
        return characterSpeed;
    }

    public String getCharacterAlignment() {
        return characterAlignment;
    }

    public Dice getCharacterHitDie() {
        return characterHitDie;
    }
}

