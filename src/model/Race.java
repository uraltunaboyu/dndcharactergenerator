package model;

public class Race {
    private String raceName;
    private String[] firstnames;
    private String[] lastnames;
    private Constants.StandardLanguages[] standardLanguages;
    private Constants.ExoticLanguages[] exoticLanguages;
    private Constants.Tools[] toolProficiencies;
    private int[] statIncreases;
    private int speed;

    public Race(String raceName, String[] firstnames, String[] lastnames,
                Constants.StandardLanguages[] standardLanguages, Constants.ExoticLanguages[] exoticLanguages,
                Constants.Tools[] toolProficiencies, int[] statIncreases, int speed) {
        this.raceName = raceName;
        this.firstnames = firstnames;
        this.lastnames = lastnames;
        this.standardLanguages = standardLanguages;
        this.exoticLanguages = exoticLanguages;
        this.toolProficiencies = toolProficiencies;
        this.statIncreases = statIncreases;
        this.speed = speed;
    }

    public String generateName() {
        return firstnames[(int) Math.random() * firstnames.length] + " " +
                lastnames[(int) Math.random() * lastnames.length];
    }

    public Constants.StandardLanguages[] getLanguages() {
        return standardLanguages;
    }
}
