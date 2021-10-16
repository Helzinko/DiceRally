/**
 * @(#) PauseCommand.java
 */

package Game.CommandPattern;

import Game.Builder_Prototype.Car;
import Game.GameWindow;

public class PauseCommand extends ICommand
{

    public PauseCommand(GameWindow target) {
        super(target);
    }

    @Override
    public void execute() {

    }

    @Override
    public void undo() {

    }
}
