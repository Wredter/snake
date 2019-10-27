package Snake.GameObjects.Static;

import java.util.Random;

public class Mouse {
    public int bodyXPos;
    public int bodyYPos;

    public Mouse(int boardSizeX,int boardSizeY){
        Random rng = new Random();
        bodyXPos = rng.nextInt(boardSizeX);
        bodyYPos = rng.nextInt(boardSizeY);
    }
}
