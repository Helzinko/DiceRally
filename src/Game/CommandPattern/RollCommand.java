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
        int rolledNumber = Dice.Roll();
        return  rolledNumber;
    }

    @Override
    public int execute(Message msg) {
        return 0;
    }

    @Override
    public void undo() {

    }
}
