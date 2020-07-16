package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CharacterTest {
    CharacterFactory characterFactoryTest;
    Character characterTest;

    @BeforeEach
    public void setup() {
        characterFactoryTest =  new CharacterFactory();
    }

    @Test
    public void characterBuildTest() {
        characterTest = characterFactoryTest.build();
        assertNotNull(characterTest.getCharacterName());
    }

}
