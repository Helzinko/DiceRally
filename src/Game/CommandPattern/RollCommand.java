/**
 * @(#) RollCommand.java
 */

package Game.CommandPattern;

import Game.Dice;

public class RollCommand extends ICommand
{

    public RollCommand(Dice dice) {
        super(dice);
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
