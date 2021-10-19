/**
 * @(#) PauseCommand.java
 */

package Game.CommandPattern;

import Game.Builder_Prototype.Car;
import Game.GameWindow;
import Game.Message;

public class PauseCommand extends ICommand
{

    public PauseCommand() {
        super();
    }

    @Override
    public int execute() {
        return 0;
    }

    @Override
    public int execute(Message msg) {
        return 0;
    }

    @Override
    public void undo() {

    }
}
