package ui;

public class CharacterCreator {

    public static void main(String[] args) {
        for(int i = 1; i < 21; i++) {
            System.out.println((i / 4) + 1 + (i % 4 == 0 ? 0 : 1));
        }
    }
}
