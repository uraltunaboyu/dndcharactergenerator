package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static model.Constants.StandardLanguages.Common;
import static model.Constants.StandardLanguages.Dwarvish;
import static model.Constants.Tools.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class RaceTest {
    String[] firstNames = new String[]{"test1", "test2"};
    String[] lastNames = new String[]{"test3", "test4"};
    Race testRace;

    @BeforeEach
    public void setup() {
        testRace = new Race("Dwarf", new String[] {"test1", "test2"}, new String[] {"test1", "test2"},
                new String[] {"test3", "test4"}, new Constants.StandardLanguages[]{Common, Dwarvish},
                new Constants.ExoticLanguages[0], new Constants.Tools[] {SmithTools, BrewerSupplies, MasonTools},
                new int[]{0,0,2,0,0,0}, 25);
    }


    @Test
    public void languagesTest() {
        Constants.StandardLanguages[] languages = testRace.getLanguages();
        List<Constants.StandardLanguages> languagesList = Arrays.asList(languages);
        assertTrue(languagesList.contains(Dwarvish) && languagesList.contains(Common));
    }

    @Test
    public void namingTest() {
        String name = testRace.generateName(true);
        ArrayList<String> possibleNames = new ArrayList<>();
        for(String firstName: firstNames) {
            for(String lastName: lastNames) {
                possibleNames.add(firstName + " " + lastName);
            }
        }
        if (!possibleNames.contains(name)) {
            System.out.println(name);
            fail();
        }
    }
}
