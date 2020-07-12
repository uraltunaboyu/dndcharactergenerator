package model;

import java.util.ArrayList;
import java.util.Collections;

public class CharacterFactory {
    //Variables used for generating a character object
    private String characterName;
    private Class characterClass;
    private Subclass characterSubclass;
    private Race characterRace;
    private Subrace characterSubrace;
    private int[] stats = new int[6];
    private boolean[] statProfs = new boolean[6];
    private int[] skills = new int[18];
    private int[] skillStats = new int[18];
    private boolean[] skillProfs = new boolean[18];
    //TODO: Figure out a way  to pregenerate classes and races.
    //For now, placeholder arrays will do.
    private Class[] classes = new Class[10];
    private Race[] races = new Race[10];

    public CharacterFactory() {
        characterClass = classes[(int) Math.floor(Math.random() * classes.length)];
        characterRace = races[(int) Math.floor(Math.random() * races.length)];
        characterName = characterClass.generateName();
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

    /*public Character build() {
        return Character();
    }*/
}
