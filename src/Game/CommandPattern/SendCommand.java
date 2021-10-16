/**
 * @(#) SendCommand.java
 */

package Game.CommandPattern;

import Game.Builder_Prototype.Car;
import Game.GameWindow;

public class SendCommand extends ICommand
{

    public SendCommand(GameWindow target) {
        super(target);
    }

    @Override
    public void execute() {

    }

    @Override
    public void undo() {

    }
}
