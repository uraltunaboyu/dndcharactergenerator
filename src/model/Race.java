package model;

import java.util.HashMap;

public class Race {
    private String raceName;
    private String[] firstnames;
    private String[] lastnames;
    private Constants.StandardLanguages[] languages;
    private Subrace[] subraces;
    private HashMap<Constants.statNames, Integer> statIncreases;
    private int speed;

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
