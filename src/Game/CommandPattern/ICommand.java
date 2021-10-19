/**
 * @(#) Icommand.java
 */

package Game.CommandPattern;
import Game.Builder_Prototype.Car;
import Game.Chat;
import Game.Dice;
import Game.GameWindow;
import Game.Message;

public abstract class ICommand
{
	protected Dice target;
	protected Message target1;

	public ICommand(Dice target)
	{
		super();
		this.target = target;
	}

	public ICommand(Message target1)
	{
		super();
		this.target1 = target1;
	}

	public ICommand()
	{
		super();
	}

	public abstract int execute( );

	public abstract int execute(Message msg);
	
	public abstract void undo( );
}
