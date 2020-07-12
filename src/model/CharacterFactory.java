package model;

import java.util.ArrayList;
import java.util.Collections;

public class CharacterFactory {
    private String characterName;
    private Class characterClass;
    private Subclass characterSubclass;
    private Race characterRace;
    private Subrace characterSubrace;
    private int[] stats = new int[] {-1, -1, -1, -1, -1, -1};
    //Determines how stats are rolled. False is straight d20, true is 4d6 drop lowest.
    private boolean advantageRoll = false;

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
        populateStats();
    }

    /*----------- Generate Data -----------*/

    private void createClasses() {
        //TODO: Write all classes in
    }

    private void createSubclasses() {
        //TODO: Write all subclasses
    }

    private void createRaces() {
        //TODO: Write all races in
    }

    private void createSubraces() {
        //TODO: Write all subraces
    }

    /*----------- Manage Stats -----------*/

    public void setStat(int index, int value) {
        if (0 <= index && index < 6){
            stats[index] = value;
        }
    }


    private void populateStats() {
        for(int i = 0; i < 6; i++) {
            if(stats[i] == -1) {
                stats[i] = advantageRoll? generateStatNormal() : generateStatAdv();
            }
        }
    }

    private static int generateStatNormal() {
        return (int) Math.random() * 20 + 1;
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

    /*----------- Set Factory Props -----------*/

    public void setAdvantageRoll() {
        advantageRoll = true;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public void setCharacterClass(Class characterClass) {
        this.characterClass = characterClass;
    }

    public void setCharacterSubclass(Subclass characterSubclass) {
        this.characterSubclass = characterSubclass;
    }

    public void setCharacterRace(Race characterRace) {
        this.characterRace = characterRace;
    }

    public void setCharacterSubrace(Subrace characterSubrace) {
        this.characterSubrace = characterSubrace;
    }
}
