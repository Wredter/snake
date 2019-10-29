package Snake.GameObjects.Static;

import Snake.GameObjects.GameObject;

public class GameBoard extends GameObject {
    public char[][] gameBoard;
    int XSize;
    int YSize;
    int sizeWithBorderX;
    int sizeWithBorderY;
     public GameBoard(int XSize,int YSize){
         super(0,0);
        this.XSize=XSize;
        this.YSize=YSize;
        sizeWithBorderX = XSize + 2;
        sizeWithBorderY = YSize + 2;
         gameBoard = new char[sizeWithBorderX][sizeWithBorderY];
        for(int i = 0;i < sizeWithBorderX;i++){
            for(int j = 0; j < sizeWithBorderY;j++){
                if(!(j!=0 ^ j!=sizeWithBorderY-1) && !(i !=0 ^ i!=sizeWithBorderX-1)) {
                    gameBoard[i][j] = ' ';
                }else {
                    gameBoard[i][j] = '#';
                }
            }
        }
    }
    public void update(){
        for(int i =0;i<sizeWithBorderX;i++){
            for(int j=0;j<sizeWithBorderY;j++){
                System.out.print(gameBoard[i][j]);
            }
            System.out.println("");
        }
    }
    public void clear(){
        for(int i = 1;i < XSize+1;i++){
            for(int j = 1; j < YSize + 1;j++){
                gameBoard[i][j]=' ';
            }
        }
    }
}
