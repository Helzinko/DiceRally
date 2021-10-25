/**
 * @(#) Decorator.java
 */

package Game.Decorator;

import Game.Builder_Prototype.*;

public abstract class Decorator extends Car {

	protected Car wrapee;

	public Decorator(Car component) {
		super();
		this.wrapee = component;
	}

	public FuelType getFuelType()
	{
		return wrapee.getFuelType();
	}

}
