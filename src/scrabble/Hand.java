package scrabble;

import javafx.scene.control.Label;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class Hand {

    private int xVal;
    private int yVal;
    private Text text1;
    private Text text2;
    private Rectangle r;
    private Scrabble scrabble;

    public Hand(int xVal, int yVal, Text text1, Text text2, Scrabble scrabble, Rectangle r){
        this.xVal = xVal;
        this.yVal = yVal;
        this.text1 = text1;
        this.text2 = text2;
        this.r = r;
        this.scrabble = scrabble;
    }

    public void setxVal(int x) {
        this.xVal = x;
    }

    public void setyVal(int y) {
        this.yVal = y;
    }

    public int getxVal() {
        return this.xVal;
    }

    public void setRect(Rectangle r) {
        this.r = r;
    }

    public int getyVal() {
        return this.yVal;
    }

    public Text getText1(){
        return this.text1;
    }

    public Text getText2(){
        return this.text2;
    }

    public Rectangle getRect(){
        return this.r;
    }

    public Scrabble getScrabble(){
        return this.scrabble;
    }




}
