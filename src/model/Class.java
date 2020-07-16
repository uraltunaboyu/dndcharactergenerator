package model;


public class Class {
    private String className;
    private Constants.skillNames[] skillProficiencies;
    private Constants.statNames[] statProficiencies;
    private Constants.Dice hitDie;
    private Constants.Armor[] armorProficiencies;
    private Constants.Weapons[] weaponProficiencies;

    public Class(String className, Constants.skillNames[] skillProficiencies, Constants.statNames[] statProficiencies,
                 Constants.Dice hitDie, Constants.Armor[] armorProficiencies, Constants.Weapons[] weaponProficiencies) {
        this.className = className;
        this.skillProficiencies = skillProficiencies;
        this.statProficiencies = statProficiencies;
        this.hitDie = hitDie;
        this.armorProficiencies = armorProficiencies;
        this.weaponProficiencies = weaponProficiencies;
    }

    public Constants.skillNames[] getRandomSkillProficiencies() {
        int firstSkill = (int) (Math.random() * skillProficiencies.length);
        int secondSkill = (int) (Math.random() * skillProficiencies.length);
        //Make sure you don't return the same two skill proficiencies
        while (secondSkill == firstSkill) {
            secondSkill = (int) Math.random() * skillProficiencies.length;
        }
        return new Constants.skillNames[]{skillProficiencies[firstSkill], skillProficiencies[secondSkill]};
    }

    public Constants.statNames[] getStatProficiencies() {
        return statProficiencies;
    }

    public Constants.Dice getHitDie() {
        return hitDie;
    }
}
