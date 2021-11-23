/**
 * @(#) CanRoll.java
 */

package Game.State;

import Game.Builder_Prototype_Bridge.Car;

public class CanRoll extends State
{
	public void Handle(Context context, String rolledMessage)
	{
		System.out.println("Formed: " + rolledMessage);
		context.setState(this);
	}
}
