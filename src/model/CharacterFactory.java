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
    //Stats are going to be duplicated first in an individual variable then in a stats array, so the player can
    //choose to input stats manually or roll for them.
    private int strength;
    private int dexterity;
    private int constitution;
    private int intelligence;
    private int wisdom;
    private int charisma;
    private int[] stats = new int[6];
    //Proficiencies and skills will be generated as the class and race determines those.
    private boolean[] statProfs = new boolean[6];
    private int[] skills = new int[18];
    private int[] skillStats = new int[18];
    private boolean[] skillProfs = new boolean[18];

    //For now, placeholder arrays will do.
    private Class[] classes = new Class[10];
    private Race[] races = new Race[10];

    public CharacterFactory() {
        characterClass = classes[(int) Math.floor(Math.random() * classes.length)];
        characterRace = races[(int) Math.floor(Math.random() * races.length)];
        characterName = characterRace.generateName();
        characterSubclass = characterClass.getRandomSubclass();
    }

    private void createClasses() {

    }

    private void createSubclasses() {

    }

    private void createRaces() {

    }

    private void createSubraces() {

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
