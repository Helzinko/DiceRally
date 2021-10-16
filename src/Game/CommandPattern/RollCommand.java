/**
 * @(#) RollCommand.java
 */

package Game.CommandPattern;

import Game.Builder_Prototype.Car;
import Game.Dice;

public class RollCommand extends ICommand
{

    public RollCommand(Dice target) {
        super(target);
    }

    @Override
    public void execute() {
        Dice.Roll();
    }

    @Override
    public void undo() {

    }
}
