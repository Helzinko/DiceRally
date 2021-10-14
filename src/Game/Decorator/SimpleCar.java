/**
 * @(#) SimpleCar.java
 */

package Game.Decorator;

import Game.Builder_Prototype.*;

public class SimpleCar extends Car
{
	private Car car;

	public SimpleCar(BodyType bodyType, double power, FuelType fuelType, Shield shield, Antena antena, CarColor color) {
		super(bodyType, power, fuelType, shield, antena, color);
	}

	public BodyType getBodyType( )
	{
		return car.getBodyType();
	}
}
