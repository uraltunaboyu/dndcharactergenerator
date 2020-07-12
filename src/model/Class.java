package model;


public class Class {
    private String className;
    private Constants.skillNames skillProficiencies;
    private Constants.statNames statProficiencies;
    private Constants.Dice hitDie;
    private Constants.Armor armorProficiencies;
    private Constants.Weapons weaponProficiencies;
    private Constants.Tools toolProficiencies;
    private Subclass[] subclasses;



    public Constants.skillNames getSkillProficiencies() {
        return skillProficiencies;
    }

    public Constants.statNames getStatProficiencies() {
        return statProficiencies;
    }

    public Subclass getRandomSubclass() {
        return subclasses[(int) Math.random() * subclasses.length];
    }

    public Constants.Dice getHitDie() {
        return hitDie;
    }
}
