package Snake.Logic;

import Snake.GameObjects.BodyPart;
import Snake.GameObjects.Head;
import Snake.GameObjects.Static.GameBoard;

import java.awt.event.KeyEvent;

public class Game {
    Head sneak;
    GameBoard gameBoard;

    public Game(int XPos,int YPos,char bodySymbol,char headSymbol, int initialLenght, int XSize,int YSize){
        sneak = new Head(XPos,YPos,bodySymbol,headSymbol,initialLenght);
        gameBoard = new GameBoard(XSize,YSize);
        BodyPart part = sneak;

        while (part.nextBodyPart != null){
            gameBoard.gameBoard[part.bodyXPos][part.bodyYPos] = part.bodySymbol;
            part = part.nextBodyPart;
        }
    }
    public void update(char input){
        gameBoard.clear();
        sneak.update(input);
        BodyPart part = sneak;
        while (part.nextBodyPart != null){
            gameBoard.gameBoard[part.bodyXPos][part.bodyYPos] = part.bodySymbol;
            part = part.nextBodyPart;
        }

        gameBoard.update();
    }
}
