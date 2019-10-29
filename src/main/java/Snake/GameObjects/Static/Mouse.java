package Snake.GameObjects.Static;

import Snake.GameObjects.GameObject;

import java.util.Random;

public class Mouse extends GameObject {

    public Mouse(int boardSizeX,int boardSizeY){
        super(0,0);
        Random rng = new Random();
        bodyXPos = rng.nextInt(boardSizeX);
        bodyYPos = rng.nextInt(boardSizeY);

    }
}
