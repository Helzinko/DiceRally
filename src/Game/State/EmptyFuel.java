/**
 * @(#) EmptyFuel.java
 */

package Game.State;

import Game.Builder_Prototype_Bridge.Car;
import Game.Chat;

public class EmptyFuel extends State
{
	public void Handle(Context context)
	{
		Chat.AddMessage("I can't move. I am out of fuel. I will miss one move :(");
		context.setState(this);
	}
	
	
}
