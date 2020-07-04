package ui;

import model.Character;

import java.util.LinkedHashMap;

public class CharacterCreator {

    public static void main(String[] args) {
        Character character = new Character(false);
        LinkedHashMap<Character.statName, Integer> stats = character.getStats();
        for (Character.statName stat: stats.keySet()) {
            System.out.printf("The value of %s is %s with mod %s\n", stat, stats.get(stat), Character.getStatMod(stats.get(stat)));
        }
    }
}
