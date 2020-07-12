package model;

public class Race {
    private String raceName;
    private String[] firstnames;
    private String[] lastnames;
    private Constants.StandardLanguages[] languages;
    private Subrace[] subraces;

    public String generateName() {
        return firstnames[(int) Math.random() * firstnames.length] + " " +
                lastnames[(int) Math.random() * lastnames.length];
    }

    public Constants.StandardLanguages[] getLanguages() {
        return languages;
    }

    public Subrace getRandomSubrace() {
        return subraces[(int) Math.random() * subraces.length];
    }
}
