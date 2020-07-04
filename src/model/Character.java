package model;

import model.classes.Class;
import model.races.Race;

import java.util.*;

public class Character {
    public Class characterClass;
    public Race characterRace;
    private enum statName {STR, DEX, CON, INT, WIS, CHA};
    private enum
    public LinkedHashMap<statName, Integer> stats = new LinkedHashMap<>();

    public Character(boolean normalRoll) {
        for (statName stat: statName.values()) {
            stats.put(stat, normalRoll ? generateStatNormal() : generateStatAdv());
        }
    }

    public LinkedHashMap<statName, Integer> getStats() {
        return stats;
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
