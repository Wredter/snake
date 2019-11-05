package Snake.GameObjects.Static;

import Snake.GameObjects.BodyPart;
import Snake.GameObjects.GameObject;
import Snake.GameObjects.Head;
import Snake.GameObjects.Static.DataTypes.SnakeData;

import java.util.Random;

public class Mouse extends GameObject {

    char bodySymbol;
    public Mouse(int boardSizeX, int boardSizeY, Head player){
        super(0,0);
        Random rng = new Random();
        bodyXPos = rng.nextInt(boardSizeX)+1;
        bodyYPos = rng.nextInt(boardSizeY)+1;
        bodySymbol = '@';
        boolean doIHaveToRoleAgain = false;
        do {
            for (SnakeData snakeData : player.getSnakePosition()) {
                if (this.toSnakeData().equals(snakeData)) {
                    bodyXPos = rng.nextInt(boardSizeX)+1;
                    bodyYPos = rng.nextInt(boardSizeY)+1;
                    doIHaveToRoleAgain = true;
                }
            }
        }while (doIHaveToRoleAgain);
    }
    private SnakeData toSnakeData(){
        return new SnakeData(bodyXPos,bodyYPos,bodySymbol);
    }
}
