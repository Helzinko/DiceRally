/**
 * @(#) PauseCommand.java
 */

package Game.CommandPattern;

import Game.Images;
import Game.Message;

import javax.swing.*;

public class PauseCommand extends ICommand
{

    public PauseCommand(JButton pause) {
        super(pause);
    }

    @Override
    public int execute() {
        this.button.setIcon(new ImageIcon(Images.play.getImage().getScaledInstance(40, 40, 0)));
        return 0;
    }

    @Override
    public void undo() {
        this.button.setIcon(new ImageIcon(Images.pause.getImage().getScaledInstance(40, 40, 0)));
    }
}
