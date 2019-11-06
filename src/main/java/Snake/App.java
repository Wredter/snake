package Snake;

import Snake.Logic.Game;

import java.math.BigInteger;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class App
{
    static boolean doIhaveToUpdate;
    static Game game;
    public static void main( String[] args )
    {
        TimerTask updater = new TimerTask() {
            @Override
            public void run() {
                    game.update('d');

                if(!game.gameState){
                    doIhaveToUpdate = false;
                }
            }
        };
        //TODO add gameclock, add board loader
        game = new Game(3,3,'x','X',3,15,15);
        Timer t = new Timer();
        doIhaveToUpdate = true;
        t.schedule(updater,900,1000);
        while (true){
            try
            {
                Thread.sleep(1000);
            }
            catch(InterruptedException ex)
            {
                Thread.currentThread().interrupt();
            }
            if(!doIhaveToUpdate) {
                t.cancel();
                return;
            }
        }
    }
}
