package Game.Interpreter;

import Game.Chat;
import Game.GameWindow;

public class CommandController {

    public static void PlayCommand(String command){

        switch (command){
            case "/roll" :
                GameWindow.dice.doClick();
                break;
            case "/pause" :
                GameWindow.pause.doClick();
                break;
            case "/exit" :
                System.exit(0);
                break;
        }

    }

}
