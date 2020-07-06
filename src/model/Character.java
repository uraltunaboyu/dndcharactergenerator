package model;

import model.classes.Class;
import model.races.Race;

import java.util.*;

public class Character {
    public Class characterClass;
    public Race characterRace;
    public static final int STR = 0;
    public static final int DEX = 1;
    public static final int CON = 2;
    public static final int INT = 3;
    public static final int WIS = 4;
    public static final int CHA = 5;
    public int[] stats = new int[6];
    private int characterLevel;
    private int proficiencyBonus;

    public int getCharacterLevel() {
        return characterLevel;
    }

    public int getProficiencyBonus() {
        return proficiencyBonus;
    }

    public Character(boolean normalRoll, int characterLevel) {
        this.characterLevel = characterLevel;
        for (int i = 0; i < 6; i++) {
            stats[i] = (normalRoll ? generateStatNormal() : generateStatAdv());
        }
        //Proficiency bonus = (level/4) + 1, rounded up
        proficiencyBonus = (characterLevel / 4) + 1 + (characterLevel % 4 == 0 ? 0 : 1);
        //^ This is a really hacky way of simulating that. It sucks and I hate it.
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

    public static int getStatMod(int stat) {
        return (stat - 10) / 2;
    }
}
