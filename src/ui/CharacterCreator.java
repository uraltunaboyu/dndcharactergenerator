package ui;

public class CharacterCreator {

    public static void main(String[] args) {
        //TODO: Start writing a CLI to walk the player through character generation.
        for(int i = 1; i < 21; i++) {
            System.out.println((int) Math.floor(Math.random() * 10));
        }
        //TODO: Figure out a PDF interface to create a viable output.
    }
}
