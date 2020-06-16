package scrabble;

import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.util.Collections;

public class Frequency extends Main {

    public static void frequencyScrabble() {
        createScrabble('E', 12, 1);
        createScrabble('A', 9, 1);
        createScrabble('I', 9, 1);
        createScrabble('O', 8, 1);
        createScrabble('N', 6, 1);
        createScrabble('R', 6, 1);
        createScrabble('T', 6, 1);
        createScrabble('L', 4, 1);
        createScrabble('S', 4, 1);
        createScrabble('U', 4, 1);

        createScrabble('D', 4, 2);
        createScrabble('G', 3, 2);

        createScrabble('B', 2, 3);
        createScrabble('C', 2, 3);
        createScrabble('M', 2, 3);
        createScrabble('P', 2, 3);

        createScrabble('F', 2, 4);
        createScrabble('H', 2, 4);
        createScrabble('V', 2, 4);
        createScrabble('W', 2, 4);
        createScrabble('Y', 2, 4);

        createScrabble('b', 2, 0); // Blank

        createScrabble('K', 1, 5);

        createScrabble('J', 1, 8);
        createScrabble('X', 1, 8);
        createScrabble('Q', 1, 10);
        createScrabble('Z', 1, 10);

    }

    public static void createScrabble(char letter, int frequency, int wordScore){
        while(frequency >= 0){
            scrabbleList.add(new Hand(-500,-500,
                    new Text(""), new Text(""),new Scrabble(wordScore,letter), new Rectangle()));
            frequency--;
        }
        Collections.shuffle(scrabbleList); // Shuffles scrabbles
    }


}
