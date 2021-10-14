/**
 * @(#) Roadster.java
 */

package Game.Decorator;

import Game.Builder_Prototype.*;

public class Roadster extends Decorator
{
	private Car car;
	public Roadster(BodyType bodyType, double power, FuelType fuelType, Shield shield, Antena antena, CarColor color) {
		super(bodyType, power, fuelType, shield, antena, color);
	}

	public BodyType getBodyType( )
	{
		return car.getBodyType();
	}
}
