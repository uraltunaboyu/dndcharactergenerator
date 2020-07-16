package ui;

import model.CharacterFactory;
import model.Class;
import model.Constants;
import model.Race;

import static model.Constants.Armor.*;
import static model.Constants.Armor.Shield;
import static model.Constants.StandardLanguages.Common;
import static model.Constants.StandardLanguages.Dwarvish;
import static model.Constants.Tools.*;
import static model.Constants.Weapons.Martial;
import static model.Constants.Weapons.Simple;
import static model.Constants.skillNames.*;
import static model.Constants.skillNames.Intimidation;
import static model.Constants.statNames.Charisma;
import static model.Constants.statNames.Wisdom;

public class CharacterCreator {

    CharacterFactory characterFactory;

    public static void main(String[] args) {
        //TODO: Start writing a CLI to walk the player through character generation.
        //TODO: Figure out a PDF interface to create a viable output.
    }

    private void createData() {
        createClasses();
        createSubclasses();
        createRaces();
        createSubraces();
    }

    private void createClasses() {
        characterFactory.addToClasses(new Class("Paladin", new Constants.skillNames[] {Athletics, Insight, Intimidation, Medicine, Persuasion, Intimidation},
                new Constants.statNames[] {Wisdom, Charisma}, Constants.Dice.d10, new Constants.Armor[]{Light, Medium, Heavy, Shield},
                new Constants.Weapons[] {Simple, Martial}));
    }

    private void createSubclasses() {

    }

    private void createRaces() {
        characterFactory.addToRaces(new Race("Dwarf", new String[] {"test1", "test2"}, new String[] {"test3", "test4"},
                new Constants.StandardLanguages[]{Common, Dwarvish}, new Constants.ExoticLanguages[0],
                new Constants.Tools[] {SmithTools, BrewerSupplies, MasonTools}, new int[]{0,0,2,0,0,0}, 25));
    }

    private void createSubraces() {

    }
}
