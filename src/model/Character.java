package model;

import exceptions.StatNotFound;
import model.classes.Class;
import model.races.Race;

import java.util.*;

public class Character {
    public String characterName;
    public Class characterClass;
    public Race characterRace;
    private HashMap<String, Integer> characterStats;
    private int characterLevel;
    private int proficiencyBonus;

    public int getCharacterLevel() {
        return characterLevel;
    }

    public int getProficiencyBonus() {
        return proficiencyBonus;
    }

    public Character(boolean normalRoll, int characterLevel) {
        int[] stats = new int[6];
        this.characterLevel = characterLevel;
        for (int i = 0; i < 6; i++) {
            stats[i] = (normalRoll ? generateStatNormal() : generateStatAdv());
        }
        //Proficiency bonus = (level/4) + 1, rounded up
        proficiencyBonus = (characterLevel / 4) + 1 + (characterLevel % 4 == 0 ? 0 : 1);
        //^ This is a really hacky way of simulating that. It sucks and I hate it.
        characterStats.put("Strength", stats[0]);
        characterStats.put("Dexterity", stats[1]);
        characterStats.put("Constitution", stats[2]);
        characterStats.put("Intelligence", stats[3]);
        characterStats.put("Wisdom", stats[4]);
        characterStats.put("Charisma", stats[5]);
    }

    private static int generateStatNormal() {
        return (int) (Math.random() * 20 + 1);
    }

    private static int generateStatAdv() {
        int stat = 0;
        ArrayList<Integer> rolls = new ArrayList<>();
        for (int i = 0; i < 4; i++){
            rolls.add((int) (Math.random() * 6 + 1));
        }
        Collections.sort(rolls);
        rolls.remove(0);
        for (int roll: rolls) {
            stat += roll;
        }
        return stat;
    }

    public int getStatMod(String statName) throws StatNotFound {
        if (characterStats.containsKey(statName)) {
            return (characterStats.get(statName) - 10) / 2;
        } else {
            throw new StatNotFound();
        }
    }
}
