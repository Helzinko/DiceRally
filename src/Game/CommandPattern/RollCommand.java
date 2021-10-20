/**
 * @(#) RollCommand.java
 */

package Game.CommandPattern;

import Game.Builder_Prototype.Car;
import Game.Dice;
import Game.Message;

public class RollCommand extends ICommand
{

    public RollCommand(Dice target) {
        super(target);
    }

    @Override
    public int execute() {
        int rolledNumber = this.dice.Roll();
        return  rolledNumber;
    }

    @Override
    public void undo() {

    }
}
