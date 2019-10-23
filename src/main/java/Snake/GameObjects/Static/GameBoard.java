package Snake.GameObjects.Static;

import Snake.GameObjects.Head;

public class GameBoard {
    public char[][] gameBoard;
    Head sneak;
    int XSize;
    int YSize;
     public GameBoard(int XSize,int YSize){
        gameBoard = new char[XSize][YSize];
        this.XSize=XSize;
        this.YSize=YSize;
        for(int i =0;i<XSize;i++){
            for(int j=0;j<YSize;j++){
                gameBoard[i][j]=' ';
            }
        }
    }
    public void update(){
        for(int i =0;i<XSize;i++){
            for(int j=0;j<YSize;j++){
                System.out.print(gameBoard[i][j]);
            }
            System.out.println("");
        }
    }
}
