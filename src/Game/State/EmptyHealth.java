/**
 * @(#) EmptyHealth.java
 */

package Game.State;

import Game.Builder_Prototype_Bridge.Car;
import Game.Chat;

public class EmptyHealth extends State
{
	public void Handle(Context context)
	{
		Chat.AddMessage("My car is broken. I can't. I will miss one move until my team fixes it.");
		context.setState(this);
	}
}
