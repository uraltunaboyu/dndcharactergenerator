package model;

public class Race {
    private String[] firstnames;
    private String[] lastnames;
    private Constants.StandardLanguages[] languages;
    private Subrace[] subraces;

    public String generateName() {
        return firstnames[(int) Math.floor(Math.random() * firstnames.length)] + " " +
                lastnames[(int) Math.floor(Math.random() * lastnames.length)];
    }

    public Constants.StandardLanguages[] getLanguages() {
        return languages;
    }

    public Subrace getRandomSubrace() {
        return subraces[(int) Math.floor(Math.random() * subraces.length)];
    }
}
