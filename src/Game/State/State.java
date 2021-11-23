/**
 * @(#) State.java
 */

package Game.State;

import Game.Builder_Prototype_Bridge.Car;

public abstract class State
{
	public void Handle(Context context) {

	}

	public void Handle(Context context, Car car) {

	}

	public void Handle(Context context, String rolledMessage) {

	}
}
