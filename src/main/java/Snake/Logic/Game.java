package Snake.Logic;

import Snake.GameObjects.BodyPart;
import Snake.GameObjects.GameObject;
import Snake.GameObjects.Head;
import Snake.GameObjects.Static.GameBoard;

import java.util.ArrayList;


public class Game {
    Head sneak;
    GameBoard gameBoard;
    ArrayList<GameObject> everyObject;
    public boolean gameState = true;

    public Game(int XPos,int YPos,char bodySymbol,char headSymbol, int initialLenght, int XSize,int YSize){
        everyObject = new ArrayList<>();
        sneak = new Head(XPos,YPos,bodySymbol,headSymbol,initialLenght);
        everyObject.add(sneak);
        gameBoard = new GameBoard(XSize,YSize);
        everyObject.add(gameBoard);
        BodyPart part = sneak;

    }
    public void update(char input){
        sneak.update(input);
        gameBoard.update(sneak);
        if(!gameBoard.gameState){
            gameState = false;
            return;
        }

    }
}
