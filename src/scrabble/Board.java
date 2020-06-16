package scrabble;

public class Board {
    private int column;
    private int row;
    private int bMultiply;
    private int multiple;
    private Boolean isOccupied;
    private char character;
    private Scrabble scrabble;

    public Board(int row, int column,int bMultiply, Scrabble scrabble, Boolean isOccupied){
        this.column = column;
        this.row = row;
        this.bMultiply = bMultiply;
        this.scrabble = scrabble;
        this.isOccupied = isOccupied;
    }

    public void setScrabble(Scrabble s) {
        this.scrabble = s;
    }

    public Scrabble getScrabble() {
        return this.scrabble;
    }

    public int getbMultiply(){
        return this.bMultiply;
    }

    public void setbMultiply(int b) {
        this.bMultiply = b;
    }
    public int getColumn(){
        return this.column;
    }
    public int getRow(){
        return this.row;
    }
    public boolean getIsOccupied() {
        return this.isOccupied;
    }
    public void setIsOccupied(Boolean b) {
        this.isOccupied = b;
    }
}
