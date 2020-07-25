package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CharacterFactory {
    private String characterName;
    private boolean characterIsMale;
    private Class characterClass;
    private Subclass characterSubclass;
    private Race characterRace;
    private Subrace characterSubrace;
    private int characterLevel;
    private int[] stats = new int[] {-1, -1, -1, -1, -1, -1};
    public static final String[] alignments = new String[] {"Lawful Good", "Neutral Good", "Chaotic Good",
            "Lawful Neutral", "True Neutral", "Chaotic Neutral", "Lawful Evil", "Neutral Evil", "Chaotic Evil"};
    private String characterAlignment;
    //Determines how stats are rolled. False is straight d20, true is 4d6 drop lowest.
    private boolean advantageRoll = false;

    //Proficiencies and skills will be generated as the class and race determines those.
    private boolean[] statProfs = new boolean[6];
    private boolean[] skillProfs = new boolean[18];

    //For now, placeholder arrays will do.
    private ArrayList<Class> classes = new ArrayList<>();
    private ArrayList<Race> races = new ArrayList<>();

    public CharacterFactory() {
        characterAlignment = alignments[(int) (Math.random() * alignments.length)];
        characterIsMale = (Math.random() < 0.5);
        characterLevel = 1;
        populateStats();
    }

    public Character build() {
        fillStatProfArray();
        fillSkillProfArray();
        return new Character(characterName, characterIsMale,characterClass, characterRace,
                characterAlignment, characterClass.getHitDie(), stats, statProfs,
                skillProfs, characterLevel);
    }

    /*----------- Add classes/races to arrays -----------*/
    public void addToClasses(Class characterClass) {
        classes.add(characterClass);
        this.characterClass = classes.get((int) (Math.random() * classes.size()));
    }

    public void addToRaces(Race characterRace) {
        races.add(characterRace);
        this.characterRace = races.get((int) (Math.random() * races.size()));
        characterName = characterRace.generateName(characterIsMale);
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

    /*----------- Populate Stat Arrays for build() -----------*/
    private void fillStatProfArray() {
        List<Constants.statNames> statProfsAsList = Arrays.asList(characterClass.getStatProficiencies());
        int i = 0;
        for(Constants.statNames stat : Constants.statNames.values()) {
            statProfs[i] = statProfsAsList.contains(stat);
            i++;
        }
    }

    private void fillSkillProfArray() {
        List<Constants.skillNames> skillProfsAsList = Arrays.asList(characterClass.getRandomSkillProficiencies());
        int i = 0;
        for(Constants.skillNames skill : Constants.skillNames.values()) {
            skillProfs[i] = skillProfsAsList.contains(skill);
            i++;
        }
    }

    /*----------- Set Factory Props -----------*/
    public void setAdvantageRoll() {
        advantageRoll = true;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public void setCharacterIsMale(boolean characterIsMale) {
        this.characterIsMale = characterIsMale;
        characterName = characterRace.generateName(characterIsMale);
    }

    public void setCharacterAlignment(int alignmentCode) {
        characterAlignment = alignments[alignmentCode];
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

    public void setCharacterLevel(int characterLevel) {
        this.characterLevel = characterLevel;
    }
}
