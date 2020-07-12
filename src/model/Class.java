package model;

public class Class {
    private String[] firstnames;
    private String[] lastnames;
    private Constants.SKILL_NAMES skillProficiencies;
    private Constants.STAT_NAMES statProficiencies;
    private Constants.DICE hitDice;

    public String generateName() {
        return firstnames[(int) Math.floor(Math.random() * firstnames.length)] + " " +
                lastnames[(int) Math.floor(Math.random() * lastnames.length)];
    }

    public Constants.SKILL_NAMES getSkillProficiencies() {
        return skillProficiencies;
    }

    public Constants.STAT_NAMES getStatProficiencies() {
        return statProficiencies;
    }

    public Constants.DICE getHitDice() {
        return hitDice;
    }
}
