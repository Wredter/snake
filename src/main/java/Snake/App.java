package Snake;

import Snake.Logic.Game;

import java.math.BigInteger;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class App
{
    static boolean doIhaveToUpdate;
    static Game game;
    static Scanner scanner;
    static char input = 'd';
    public static void main( String[] args )
    {
        class GameUpdaterTask extends TimerTask{

            char kb = 'd';
            boolean doIHaveToUpdate;
            Game game;
            public GameUpdaterTask(Game game, boolean state){
                this.game = game;
                doIhaveToUpdate = state;

            }
            @Override
            public void run() {
                game.update(kb);
                if(!game.gameState){
                    doIhaveToUpdate = false;
                    cancel();
                }
            }

            public void setKb(char kb) {
                this.kb = kb;
            }
        }
        //TODO add gameclock, add board loader
        doIhaveToUpdate = true;
        game = new Game(3,3,'x','X',3,15,15);
        GameUpdaterTask updater = new GameUpdaterTask(game, doIhaveToUpdate);
        Timer timer = new Timer("Timer");
        timer.schedule(updater,0, 1000);
        scanner = new Scanner(System.in);


        while (doIhaveToUpdate){
            switch (input = scanner.nextLine().charAt(0)) {
                case 'a':
                    updater.setKb('a');
                    break;
                case 'd':
                    updater.setKb('d');
                    break;
                case 'w':
                    updater.setKb('w');
                    break;
                case 's':
                    updater.setKb('s');
                    break;
            }
        }

    }
}
