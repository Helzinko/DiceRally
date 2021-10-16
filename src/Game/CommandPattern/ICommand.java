/**
 * @(#) Icommand.java
 */

package Game.CommandPattern;
import Game.Builder_Prototype.Car;
import Game.Dice;
import Game.GameWindow;

public abstract class ICommand
{
	protected Dice target;
	protected GameWindow target1;

	public ICommand(Dice target)
	{
		super();
		this.target = target;
	}

	public ICommand(GameWindow target1)
	{
		super();
		this.target1 = target1;
	}

	public abstract void execute( );
	
	public abstract void undo( );
}
