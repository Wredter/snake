package Snake.GameObjects.Static;

import Snake.GameObjects.GameObject;
import Snake.GameObjects.Head;
import Snake.GameObjects.Static.DataTypes.SnakeData;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class GameBoard extends GameObject {
    //public char[][] gameBoard;
    public ArrayList<BoardTile> gameBoard;
    int XSize;
    int YSize;
    int sizeWithBorderX;
    int sizeWithBorderY;
     public GameBoard(int XSize,int YSize){
         super(0,0);
         gameBoard = new ArrayList<>();
        this.XSize=XSize;
        this.YSize=YSize;
        sizeWithBorderX = XSize + 2;
        sizeWithBorderY = YSize + 2;
        for(int i = 0;i < sizeWithBorderX;i++){
            for(int j = 0; j < sizeWithBorderY;j++){
                if(!(j!=0 ^ j!=sizeWithBorderY-1) && !(i !=0 ^ i!=sizeWithBorderX-1)) {
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
                System.out.print(gameBoard.get(i*sizeWithBorderX + j*sizeWithBorderY).currentTileSymbol);
            }
            System.out.println("");
        }
    }
    public void update(Head player){
        List<SnakeData> SnakePos = player.getSnakePosition();
        for(BoardTile tile: gameBoard) {
            for (SnakeData data : SnakePos) {
                if(tile.bodyXPos == data.xBodyPos && tile.bodyYPos == data.yBodyPos){
                    tile.currentTileSymbol = data.bodySymbol;
                }else {
                    tile.currentTileSymbol = tile.defultTileSymbol;
                }
            }
        }
        this.draw();
    }
}
