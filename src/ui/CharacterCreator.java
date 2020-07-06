package ui;

import model.Character;

import java.util.LinkedHashMap;

public class CharacterCreator {

    public static void main(String[] args) {
        Character character = new Character(false, 1);
        for(int i = 1; i < 21; i++) {
            System.out.println((i / 4) + 1 + (i % 4 == 0 ? 0 : 1));
        }
    }
}
