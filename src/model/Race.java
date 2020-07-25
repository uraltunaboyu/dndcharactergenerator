package model;

public class Race {
    private String raceName;
    private String[] malenames;
    private String[] femalenames;
    private String[] lastnames;
    private Constants.StandardLanguages[] standardLanguages;
    private Constants.ExoticLanguages[] exoticLanguages;
    private Constants.Tools[] toolProficiencies;
    private int[] statIncreases;
    private int speed;

    public Race(String raceName, String[] malenames, String[] femalenames ,String[] lastnames,
                Constants.StandardLanguages[] standardLanguages, Constants.ExoticLanguages[] exoticLanguages,
                Constants.Tools[] toolProficiencies, int[] statIncreases, int speed) {
        this.raceName = raceName;
        this.malenames = malenames;
        this.femalenames = femalenames;
        this.lastnames = lastnames;
        this.standardLanguages = standardLanguages;
        this.exoticLanguages = exoticLanguages;
        this.toolProficiencies = toolProficiencies;
        this.statIncreases = statIncreases;
        this.speed = speed;
    }

    public String generateName(boolean isMale) {
        return (isMale ? malenames[(int) (Math.random() * malenames.length)] : femalenames[(int) (Math.random() * femalenames.length)]) +
                " " + lastnames[(int) (Math.random() * lastnames.length)];
    }

    public Constants.StandardLanguages[] getLanguages() {
        return standardLanguages;
    }

    @Override
    public String toString() {
        return raceName;
    }
}
