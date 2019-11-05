package Snake;

import Snake.Logic.Game;

import java.util.Scanner;

public class App
{
    public static void main( String[] args )
    {
        //TODO add gameclock, add board loader, add rewards, add board restrictions
        Game game = new Game(3,3,'x','X',3,15,15);
        Scanner in = new Scanner(System.in);
        String input = "";
        while (!input.equals("q")){
            input = in.next();
            game.update(input.toCharArray()[0]);
            if(!game.gameState){
                return;
            }
        }
    }
}
