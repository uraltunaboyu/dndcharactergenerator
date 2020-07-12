package ui;

public class CharacterCreator {

    public static void main(String[] args) {
        for(int i = 1; i < 21; i++) {
            System.out.println((int) Math.floor(Math.random() * 10));
        }
    }
}
