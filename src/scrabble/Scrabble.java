package scrabble;

import java.awt.*;

public class Scrabble {
    private int column;
    private int row;
    private int multiple;
    private char character;

    public Scrabble(int multiple, char character){
        this.multiple = multiple;
        this.character = character;
    }

    public int getMultiple() {
        return this.multiple;
    }

    public char getCharacter() {
        return this.character;
    }


}
