package model;

import exceptions.StatNotFound;

import java.util.*;

public class Character {
    private String characterName;
    private Class characterClass;
    private Race characterRace;
    private int characterHealth;
    private int characterSpeed;
    private String characterAlignment;
    private enum dice {d4, d6, d8, d10, d12, d20};
    private dice characterHitDie;
    private HashMap<String, Integer> characterStats;
    private HashMap<String, Boolean> statProficiencies;
    private HashMap<String, Integer> characterSkills;
    private HashMap<String, Integer> skillProficiencies;
    private int characterLevel;
    private int proficiencyBonus;

    public int getCharacterLevel() {
        return characterLevel;
    }

    public int getProficiencyBonus() {
        return proficiencyBonus;
    }

    public Character(String characterName, Class characterClass, Race characterRace, String characterAlignment, dice characterHitDie, HashMap<String, Integer> characterStats, HashMap<String, Boolean> statProficiencies, HashMap<String, Integer> characterSkills, HashMap<String, Integer> skillProficiencies, int characterLevel) {
        this.characterName = characterName;
        this.characterClass = characterClass;
        this.characterRace = characterRace;
        this.characterAlignment = characterAlignment;
        this.characterHitDie = characterHitDie;
        this.characterStats = characterStats;
        this.statProficiencies = statProficiencies;
        this.characterSkills = characterSkills;
        this.skillProficiencies = skillProficiencies;
        this.characterLevel = characterLevel;
    }

    private void populateStats(int [] stats) {
        characterStats.put("Strength", stats[0]);
        characterStats.put("Dexterity", stats[1]);
        characterStats.put("Constitution", stats[2]);
        characterStats.put("Intelligence", stats[3]);
        characterStats.put("Wisdom", stats[4]);
        characterStats.put("Charisma", stats[5]);

        statProficiencies.put("Strength", false);
        statProficiencies.put("Dexterity", false);
        statProficiencies.put("Constitution", false);
        statProficiencies.put("Intelligence", false);
        statProficiencies.put("Wisdom", false);
        statProficiencies.put("Charisma", false);
    }


    public void setStat(String statName, int newStat) throws StatNotFound {
        if(characterStats.containsKey(statName)) {
            characterStats.replace(statName, newStat);
        }
        throw new StatNotFound();
    }

    public int getStat(String statName) throws StatNotFound {
        if(characterStats.containsKey(statName)) {
            return characterStats.get((statName));
        }
        throw new StatNotFound();
    }

    public boolean hasProficiency(String statName) throws StatNotFound {
        if(statProficiencies.containsKey(statName)) {
            return statProficiencies.get(statName);
        }
        throw new StatNotFound();
    }

    public void setProficiency(String statName) throws StatNotFound {
        if(statProficiencies.containsKey(statName)) {
            statProficiencies.replace(statName, true);
        }
        throw new StatNotFound();
    }

    public int getStatMod(String statName) throws StatNotFound {
        if (characterStats.containsKey(statName)) {
            return (characterStats.get(statName) - 10) / 2;
        }
        throw new StatNotFound();
    }
}
