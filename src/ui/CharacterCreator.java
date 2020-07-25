package ui;

import model.CharacterFactory;
import model.Class;
import model.Constants;
import model.Race;

import java.util.Scanner;

import static model.Constants.Armor.*;
import static model.Constants.StandardLanguages.*;
import static model.Constants.Tools.*;
import static model.Constants.Weapons.Martial;
import static model.Constants.Weapons.Simple;
import static model.Constants.skillNames.*;
import static model.Constants.statNames.Charisma;
import static model.Constants.statNames.Wisdom;

public class CharacterCreator {

    static CharacterFactory characterFactory = new CharacterFactory();
    static model.Character character;

    public static void main(String[] args) {
        createData();
        Scanner inputScanner = new Scanner(System.in);
//        while(true) {
            System.out.println("Welcome to the D&D 5e Character Creator!");
            System.out.println("If you would like any field to be random, just press enter, or press [r] now to generate a random character");
            String input = inputScanner.next();
            if (input.equalsIgnoreCase("r")) {
                System.out.println("Generating random character...");
                character = characterFactory.build();
                displayCharacter();
            } else {
                System.out.println(input.toLowerCase());
            }
        //}
    }

    private static void displayCharacter() {
        System.out.println("Character generated!");
        System.out.printf("Your character, %s, is a Level %s %s %s\n", character.getCharacterName(),
                character.getCharacterLevel(), character.getCharacterClass(), character.getCharacterRace());
        System.out.println("Your character stats are:");
        for (Constants.statNames stat: Constants.statNames.values()) {
            System.out.printf("%s: %s\n", stat, character.getStat(stat));
        }
    }

    private static void createData() {
        createClasses();
        createSubclasses();
        createRaces();
        createSubraces();
    }

    private static void createClasses() {
        characterFactory.addToClasses(new Class("Paladin", new Constants.skillNames[] {Athletics, Insight, Intimidation, Medicine, Persuasion, Intimidation},
                new Constants.statNames[] {Wisdom, Charisma}, Constants.Dice.d10, new Constants.Armor[]{Light, Medium, Heavy, Shield},
                new Constants.Weapons[] {Simple, Martial}));
    }

    private static void createSubclasses() {

    }

    private static void createRaces() {
        String[] dwarfMaleNames = new String[] {"Adrik", "Alberich", "Baern", "Barendd", "Brottor", "Bruenor", "Dain", "Darrak", "Delg", "Eberk", "Einkil", "Fargrim", "Flint", "Gardain", "Harbek", "Kildrak", "Morgran", "Orsik", "Oskar", "Rangrim", "Rurik", "Taklinn", "Thoradin", "Thorin", "Tordek", "Traubon", "Travok", "Ulfgar", "Veit", "Vondal"};
        String[] dwarfFemaleNames = new String[] {"Amber", "Artin", "Audhild", "Bardryn", "Dagnal", "Diesa", "Eldeth", "Falkrunn", "Finellen", "Gunnloda", "Gurdis", "Helja", "Hlin", "Kathra", "Kristryd", "Ilde", "Liftrasa", "Mardred", "Riswynn", "Sannl", "Torbera", "Torgga", "Vistra"};
        String[] dwarfLastNames = new String[] {"Balderk", "Battlehammer", "Brawnanvil", "Dankil", "Fireforge", "Frostbeard", "Gorunn", "Holderhek", "Ironfist", "Loderr", "Lutgehr", "Rumnaheim", "Strakeln", "Torunn", "Ungart"};
        characterFactory.addToRaces(new Race("Dwarf", dwarfMaleNames, dwarfFemaleNames, dwarfLastNames,
                new Constants.StandardLanguages[]{Common, Dwarvish}, new Constants.ExoticLanguages[0],
                new Constants.Tools[] {SmithTools, BrewerSupplies, MasonTools}, new int[]{0, 0, 2, 0, 0, 0}, 25));

        String[] elfMaleNames = new String[] {"Adran", "Aelar", "Aramil", "Arannis", "Aust", "Beiro", "Berrian", "Carric", "Enialis", "Erdan", "Erevan", "Galinndan", "Hadarai", "Heian", "Himo", "Immeral", "Ivellios", "Laucian", "Mindartis", "Paelias", "Peren", "Quarion", "Riardon", "Rolen", "Soveliss", "Thamior", "Tharivol", "Theren", "Varis"};
        String[] elfFemaleNames = new String[] {"Adrie", "Althaea", "Anastrianna", "Andraste", "Antinua", "Bethrynna", "Birel", "Caelynn", "Drusilia", "Enna", "Felosial", "Ielenia", "Jelenneth", "Keyleth", "Leshanna", "Lia", "Meriele", "Mialee", "Naivara", "Quelenna", "Quillathe", "Sariel", "Shanairra", "Shava", "Silaqui", "Theirastra", "Thia", "Vadania", "Valanthe", "Xanaphia"};
        String[] elfLastNames = new String[] {"Amakiir (Gemflower)", "Amastacia (Starflower)", "Galanodel (Moonwhisper)", "Holimion (Diamonddew)", "Ilphelkiir (Gemblossom)", "Liadon (Silverfrond)", "Meliamne (Oakenheel)", "Naïlo (Nightbreeze)", "Siannodel (Moonbrook)", "Xiloscient (Goldpetal)"};
        characterFactory.addToRaces(new Race("Elf", elfMaleNames, elfFemaleNames, elfLastNames,
                new Constants.StandardLanguages[]{Common, Elvish}, new Constants.ExoticLanguages[0],
                new Constants.Tools[0], new int[]{0, 2, 0, 0, 0, 0}, 30));
    }

    private static void createSubraces() {

    }
}
