/**
 * @(#) Decorator.java
 */

package Game.Decorator;

import Game.Builder_Prototype.*;

public abstract class Decorator extends Car {
	private Car car;

	public Decorator(BodyType bodyType, double power, FuelType fuelType, Shield shield, Antena antena, CarColor color) {
		super(bodyType, power, fuelType, shield, antena, color);
	}

	public BodyType getBodyType()
	{
		return car.getBodyType();
	}

}
