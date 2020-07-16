package model;

public class Subclass extends Class {
    private String subclassName;
    private Class superClass;

    public Subclass(String className, Constants.skillNames[] skillProficiencies, Constants.statNames[] statProficiencies, Constants.Dice hitDie, Constants.Armor[] armorProficiencies, Constants.Weapons[] weaponProficiencies, String subclassName, Class superClass) {
        super(className, skillProficiencies, statProficiencies, hitDie, armorProficiencies, weaponProficiencies);
        this.subclassName = subclassName;
        this.superClass = superClass;
    }
}
