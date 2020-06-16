package scrabble;

import java.util.ArrayList;

public class CreateBoard extends Main {
    public static ArrayList<Board> createBoard(ArrayList<Board> b) {
        Scrabble temp = new Scrabble(0,'z');
        int[][]multiArray = { {3,1,1,2,1,1,1,3,1,1,1,2,1,1,3},
                              {1,2,1,1,1,3,1,1,1,3,1,1,1,2,1},
                              {1,1,2,1,1,1,2,1,2,1,1,1,2,1,1},
                              {2,1,1,2,1,1,1,2,1,1,1,2,1,1,2},
                              {1,1,1,1,2,1,1,1,1,1,2,1,1,1,1},
                              {1,3,1,1,1,3,1,1,1,3,1,1,1,3,1},
                              {1,1,2,1,1,1,2,1,2,1,1,1,2,1,1},
                              {3,1,1,2,1,1,1,5,1,1,1,2,1,1,3}, // 5 == Blank tile
                              {1,1,2,1,1,1,2,1,2,1,1,1,2,1,1},
                              {1,3,1,1,1,3,1,1,1,3,1,1,1,3,1},
                              {1,1,1,1,2,1,1,1,1,1,2,1,1,1,1},
                              {2,1,1,2,1,1,1,2,1,1,1,2,1,1,2},
                              {1,1,2,1,1,1,2,1,2,1,1,1,2,1,1},
                              {1,2,1,1,1,3,1,1,1,3,1,1,1,2,1},
                              {3,1,1,2,1,1,1,3,1,1,1,2,1,1,3}};
        for(int i = 0; i < 15; i++){
            for(int j = 0; j < 15; j++){
                b.add(new Board(i,j,multiArray[i][j],temp, false));
                System.out.println("B created at i:"+i+" j:"+j+" using multi: "+multiArray[i][j]);
            }
        }

        return b;
    }



}
