package Snake.GameObjects.Static;

import Snake.GameObjects.GameObject;
import Snake.GameObjects.Head;
import Snake.GameObjects.Static.DataTypes.SnakeData;
import java.util.ArrayList;
import java.util.List;

public class GameBoard extends GameObject {
    public ArrayList<BoardTile> gameBoard;
    int XSize;
    int YSize;
    int sizeWithBorderX;
    int sizeWithBorderY;
    public boolean gameState = true;
     public GameBoard(int XSize,int YSize){
         super(0,0);
         gameBoard = new ArrayList<>();
        this.XSize=XSize;
        this.YSize=YSize;
        sizeWithBorderX = XSize + 2;
        sizeWithBorderY = YSize + 2;
        for(int i = 0;i < sizeWithBorderX;i++){
            for(int j = 0; j < sizeWithBorderY;j++){
                if((j != 0) == (j != sizeWithBorderY - 1) && (i != 0) == (i != sizeWithBorderX - 1)) {
                    gameBoard.add(new BoardTile(i,j,true,' '));
                }else {
                    gameBoard.add(new BoardTile(i,j,false,'#'));
                }
            }
        }
    }
    public void draw(){
        for(int i =0;i<sizeWithBorderX;i++){
            for(int j=0;j<sizeWithBorderY;j++){
                System.out.print(gameBoard.get(i*sizeWithBorderX + j).currentTileSymbol);
            }
            System.out.println("");
        }
    }
    public void update(Head player){
        List<SnakeData> SnakePos = player.getSnakePosition();
        SnakeData last = SnakePos.get(SnakePos.size()-1);
        SnakeData first = SnakePos.get(0);

        for(SnakeData part : SnakePos){
            gameBoard.get((part.xBodyPos)*sizeWithBorderX + part.yBodyPos).currentTileSymbol = part.bodySymbol;
            if(!part.equals(first)) {
                gameBoard.get((part.xBodyPos) * sizeWithBorderX + part.yBodyPos).canEnter = false;
            }
        }
        SnakeData shadow = new SnakeData(last.prevXBodyPos,last.prevYBodyPos,last.bodySymbol);
        if(!first.equals(shadow))
            gameBoard.get((last.prevXBodyPos) * sizeWithBorderX + last.prevYBodyPos).currentTileSymbol = gameBoard.get((last.prevXBodyPos) * sizeWithBorderX + last.yBodyPos).defultTileSymbol;
            gameBoard.get((last.prevXBodyPos) * sizeWithBorderX + last.prevYBodyPos).canEnter = true;
        this.draw();
        for(BoardTile tile : gameBoard){
            if(!tile.canEnter){
                if(first.xBodyPos == tile.bodyXPos && first.yBodyPos == tile.bodyYPos){
                    System.out.println("Game Over");
                    gameState = false;
                    return;
                }
            }
        }


    }
}
