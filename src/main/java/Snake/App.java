package Snake;

import Snake.Logic.Game;

import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Scanner;

public class App
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        Game game = new Game(3,3,'x','X',3,15,15);

        Scanner in = new Scanner(System.in);
        String input = null;
        while (input !="q"){
            try {
                Runtime.getRuntime().exec("cls");
            } catch (IOException e) {
                e.printStackTrace();
            }
            input = in.next();
            game.update(input.toCharArray()[0]);
        }
    }
}
