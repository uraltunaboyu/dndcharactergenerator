package model;

public class Subrace extends Race{
    private String subraceName;
    private Race superRace;

    public Subrace(String raceName, String[] firstnames, String[] lastnames,
                   Constants.StandardLanguages[] standardLanguages, Constants.ExoticLanguages[] exoticLanguages,
                   Constants.Tools[] toolProficiencies, int[] statIncreases, int speed, String subraceName,  Race superRace) {
        super(raceName, firstnames, lastnames, standardLanguages, exoticLanguages, toolProficiencies,
                statIncreases, speed);
        this.subraceName = subraceName;
        this.superRace = superRace;
    }
}
