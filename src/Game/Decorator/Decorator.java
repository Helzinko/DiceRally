/**
 * @(#) Decorator.java
 */

package Game.Decorator;

import Game.Builder_Prototype.*;

public abstract class Decorator extends Car {

	private final Car wrapee;

	public Decorator(Car component) {
		super();
		wrapee = component;
	}

	public FuelType getFuelType()
	{
		return wrapee.getFuelType();
	}

}
