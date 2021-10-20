/**
 * @(#) Icommand.java
 */

package Game.CommandPattern;
import Game.Dice;
import Game.Message;

import javax.swing.*;

public abstract class ICommand
{
	protected Dice dice;
	protected Message message;
	protected JButton button;

	public ICommand(Dice dice)
	{
		super();
		this.dice = dice;
	}

	public ICommand(Message message)
	{
		super();
		this.message = message;
	}

	public ICommand(JButton button)
	{
		super();
		this.button = button;
	}

	public abstract int execute( );
	
	public abstract void undo( );
}
