//Alex Hill
//CS-351
//March 2019
package scrabble;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main extends Application {



    //Need to fix all these public vars
    public static ArrayList<Hand> playerHand = new ArrayList<>();
    public static ArrayList<Hand> enemyHand = new ArrayList<>();
    public static ArrayList<Hand> scrabbleList = new ArrayList<>();
    public static ArrayList<Board> boardMap = new ArrayList<>();
    private static ArrayList<Rectangle> rList = new ArrayList<>();
    private static ArrayList<Text> multiText = new ArrayList<>();
    private static ArrayList<Line> lines = new ArrayList<>();
    //private static HashMap<String, > wordlist = new HashMap<String, int>();
    private static Button b1 = new Button("End Turn");
    private static boolean beingDragged = false;
    private static boolean endTurn = false;
    private static Pane root;
    //private Scanner file = new Scanner(new FileReader("wordlist.txt"));
    private static final int WIDTH = 600;
    private static final int HEIGHT = 800;
    private static final int BOXSIZE = (HEIGHT-200)/15;


    public Parent defaultGame() {
        root = new Pane();
        root.setPrefSize(WIDTH, HEIGHT);
        AnimationTimer timer = new AnimationTimer() {
            public void handle(long now) {
                gameLoop();
            }
        };



        boardMap = CreateBoard.createBoard(boardMap);
        Frequency.frequencyScrabble();


        //root.getChildren().addAll(null);
        drawLines();
        drawMultColor();
        drawBoard();
        scrabbleHand(playerHand);
        drawHand();
        b1.setLayoutX(400);
        b1.setLayoutY(650);
        b1.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                endTurn = true;
            }
        });
        root.getChildren().addAll(b1);
        for(int j = 0; j < rList.size(); j++){
            root.getChildren().addAll(rList.get(j));
        }
        for(int i = 0; i < lines.size(); i++){
            root.getChildren().addAll(lines.get(i));
        }
        for(int i = 0; i < scrabbleList.size(); i++){
            root.getChildren().addAll(scrabbleList.get(i).getRect());
            root.getChildren().addAll(scrabbleList.get(i).getText1());
            root.getChildren().addAll(scrabbleList.get(i).getText2());
        }
        for(int k = 0; k < multiText.size(); k++){
            root.getChildren().addAll(multiText.get(k));
        }
        for(int h = 0; h < playerHand.size(); h++){

            root.getChildren().addAll(playerHand.get(h).getRect());
            root.getChildren().addAll(playerHand.get(h).getText1());
            root.getChildren().addAll(playerHand.get(h).getText2());
        }
        timer.start();







        return root;
    }




    @Override
    public void start(Stage stage) {
        stage.setTitle("Scrabble V1.0");
        stage.setScene(new Scene(defaultGame()));
        stage.show();
    }



    public void gameLoop() {
        updatePos();
        if(endTurn){
            placeOnBoard();
            scrabbleHand(playerHand);
            drawHand();
            refreshCanvas();
            drawBoard();
            endTurn = false;



        }

        if(!beingDragged) {
            for(int i = 0; i < playerHand.size(); i++){
                //DEBUG double oneX = (double)playerHand.get(i).getxVal()/BOXSIZE;
                //DEBUG System.out.println(oneX);
                //DEBUG double oneY = (double)playerHand.get(i).getyVal()/BOXSIZE;
                //DEBUG System.out.println(oneY);
                if(playerHand.get(i).getyVal() < 600){
                    playerHand.get(i).getRect().setX(
                            Math.round((double)playerHand.get(i).getxVal()/BOXSIZE)*BOXSIZE);
                    playerHand.get(i).getRect().setY(
                            Math.round((double)playerHand.get(i).getyVal()/BOXSIZE)*BOXSIZE);
                    playerHand.get(i).setxVal(
                            (playerHand.get(i).getxVal()/BOXSIZE)*BOXSIZE);
                    playerHand.get(i).setyVal(
                            (playerHand.get(i).getyVal()/BOXSIZE)*BOXSIZE);

                }
            }
        }

    }


    public void placeOnBoard() {
        for(int i = 0; i < boardMap.size(); i++){
                for(int j = 0; j < playerHand.size(); j++){
                    if((playerHand.get(j).getyVal() < 600) ){
                        System.out.println(j);
                        if((playerHand.get(j).getxVal()/BOXSIZE == boardMap.get(i).getRow())
                        && (playerHand.get(j).getyVal()/BOXSIZE) == boardMap.get(i).getColumn()){
                            boardMap.get(i).setIsOccupied(true);
                            boardMap.get(i).setScrabble(playerHand.get(j).getScrabble());
                            playerHand.remove(j);
                            //DEBUG System.out.println("test");
                        } else {
                            //DEBUG System.out.println("MISMATCH: row: "+boardMap.get(j).getRow()+" X VAL:"+playerHand.get(i).getxVal()/BOXSIZE);
                            //DEBUG System.out.println("MISMATCH: column: "+boardMap.get(j).getColumn()+" Y VAL:"+playerHand.get(i).getyVal()/BOXSIZE);
                            //DEBUG System.out.println("MISMATCH: column: "+boardMap.get(j).getColumn()+" Y VAL:"+playerHand.get(i).getyVal());
                    }
                }
            }
        }
    }

    public String searchBoard(int x, int y) {
        String temp = "";
        for(int i = 0; i < boardMap.size(); i++){
            //if(boardMap.get(i).getScrabble() != NULL) {
            // }
        }
        return temp;
    }

    public void drawBoard() {
        for(int j = 0; j < boardMap.size(); j++) {
            if(!boardMap.get(j).getIsOccupied()) {
                Text text = new Text(
                        (boardMap.get(j).getColumn() * BOXSIZE) + 10,
                        (boardMap.get(j).getRow() * BOXSIZE) + 25,
                        boardMap.get(j).getbMultiply() + "x");
                multiText.add(text);
            } else {
                System.out.println(boardMap.get(j));
                Rectangle r1 = new Rectangle();
                Text t1 = new Text();
                Text t2 = new Text();
                t1.setX((boardMap.get(j).getRow()*BOXSIZE) +15 );
                t1.setY((boardMap.get(j).getColumn()*BOXSIZE) +20 );
                t1.setText(""+boardMap.get(j).getScrabble().getCharacter());
                t2.setX((boardMap.get(j).getRow()*BOXSIZE) +25 );
                t2.setY((boardMap.get(j).getColumn()*BOXSIZE) +25 );
                t2.setText(""+boardMap.get(j).getScrabble().getMultiple());

                r1.setX(boardMap.get(j).getRow()*BOXSIZE);
                r1.setY(boardMap.get(j).getColumn()*BOXSIZE);
                r1.setHeight(BOXSIZE);
                r1.setWidth(BOXSIZE);
                r1.setFill(Color.YELLOW);
                root.getChildren().addAll(r1,t1,t2);
            }
        }
    }

    public void drawMultColor() {
        for(int i = 0; i < boardMap.size(); i++){
            Rectangle r = new Rectangle();
            if(boardMap.get(i).getbMultiply() == 3 && !boardMap.get(i).getIsOccupied()){
                r.setX(boardMap.get(i).getColumn()*BOXSIZE);
                r.setY(boardMap.get(i).getRow()*BOXSIZE);
                r.setHeight(BOXSIZE);
                r.setWidth(BOXSIZE);
                r.setFill(Color.RED);
                rList.add(r);
            }
            else if(boardMap.get(i).getbMultiply() == 2 && !boardMap.get(i).getIsOccupied()){
                r.setX(boardMap.get(i).getColumn()*BOXSIZE);
                r.setY(boardMap.get(i).getRow()*BOXSIZE+.001);
                r.setHeight(BOXSIZE);
                r.setWidth(BOXSIZE);
                r.setFill(Color.PINK);
                rList.add(r);
            }
            else if(boardMap.get(i).getbMultiply() == 5){
                boardMap.get(i).setbMultiply(0);
                r.setX(boardMap.get(i).getColumn()*BOXSIZE);
                r.setY(boardMap.get(i).getRow()*BOXSIZE+.0001);
                r.setHeight(BOXSIZE);
                r.setWidth(BOXSIZE);
                r.setFill(Color.PURPLE);
                rList.add(r);
            }
        }
    }

    public void drawLines() {
        for(int i = 1; i <= 15; i++){
            Line line = new Line(BOXSIZE*i,0,BOXSIZE*i,WIDTH);
            Line line2 = new Line(0,BOXSIZE*i,HEIGHT-200,BOXSIZE*i);
            lines.add(line);
            lines.add(line2);
        }
    }



    public void scrabbleHand(ArrayList<Hand> a) {
        int currentHand = a.size();
        System.out.println(a.size());
        Rectangle tempRect = new Rectangle();
        while(a.size() < 7) {
            Scrabble temp = scrabbleList.get((scrabbleList.size()-1)).getScrabble();
            a.add(new Hand(0, //200+(currentHand*BOXSIZE)
                           0, //620
                            new Text(0, 0,""+temp.getCharacter()),
                            new Text(0, 0,""+temp.getMultiple()),
                            temp,       //200+(currentHand*BOXSIZE) , 620
                            tempRect)   // 205+(currentHand*BOXSIZE),630
                         );

            scrabbleList.remove(scrabbleList.size()-1);
            currentHand++;
        }

    }

    public void refreshCanvas() {
        for(int i = 0; i < playerHand.size(); i++){
            root.getChildren().removeAll(playerHand.get(i).getRect(),playerHand.get(i).getText1(),
                    playerHand.get(i).getText2());
        }
        for(int i = 0; i < playerHand.size(); i++){
            root.getChildren().addAll(playerHand.get(i).getRect(),playerHand.get(i).getText1(),
                    playerHand.get(i).getText2());
        }

    }

    public void drawHand() {
        for(int i = 0; i < playerHand.size(); i++){
            playerHand.get(i).setxVal(200+(i*BOXSIZE));
            playerHand.get(i).setyVal(620);
            Rectangle r = new Rectangle();
            r.setX(playerHand.get(i).getxVal()-15);
            r.setY(playerHand.get(i).getyVal()-15);
            r.setWidth(BOXSIZE);
            r.setHeight(BOXSIZE);
            r.setStroke(Color.YELLOW);
            r.setFill(Color.YELLOW);
            playerHand.get(i).setRect(r);
            makeDraggable(playerHand.get(i).getRect());
        }
    }

    public void updatePos(){
        for(int i = 0; i < playerHand.size(); i++){
            playerHand.get(i).getText1().setX(playerHand.get(i).getRect().getX()+15);
            playerHand.get(i).getText1().setY(playerHand.get(i).getRect().getY()+20);
            playerHand.get(i).getText2().setX(playerHand.get(i).getRect().getX()+30);
            playerHand.get(i).getText2().setY(playerHand.get(i).getRect().getY()+35);
            playerHand.get(i).setxVal((int)playerHand.get(i).getRect().getX());
            playerHand.get(i).setyVal((int)playerHand.get(i).getRect().getY());
        }
    }

    //public void updateRect() {
      //  for(int i = 0; i < playerHand.size(); i++){
        //    playerHand.get(i).getRect().setX(playerHand.get(i).getRect().getLayoutX());
          //  playerHand.get(i).getRect().setY(playerHand.get(i).getRect().getLayoutY());
        //}
    //}

    public void makeDraggable(Rectangle r) {
        r.setOnMousePressed( onMousePressedEventHandler);
        r.setOnMouseReleased(onMouseReleasedEventHandler);
        r.setOnMouseDragged( onMouseDraggedEventHandler);
    }

    class DragContext {
        double x;
        double y;
    }

    DragContext dragContext = new DragContext();

    EventHandler<MouseEvent> onMousePressedEventHandler = event -> {

        Rectangle r = ((Rectangle) (event.getSource()));

        dragContext.x = r.getX() - event.getSceneX();
        dragContext.y = r.getY() - event.getSceneY();
        beingDragged = true;
    };

    EventHandler<MouseEvent> onMouseReleasedEventHandler = event -> {
        beingDragged = false;
    };

    EventHandler<MouseEvent> onMouseDraggedEventHandler = event -> {

        Rectangle r = ((Rectangle) (event.getSource()));

        r.setX( dragContext.x + event.getSceneX());
        r.setY( dragContext.y + event.getSceneY());
        beingDragged = true;

    };





    public static void main(String[] args) {
        launch(args);
    }
}
