/**
 * @(#) Pickup.java
 */

package Game.Decorator;

import Game.Builder_Prototype.*;

public class Pickup extends Decorator
{
	private Car car;
	public Pickup(BodyType bodyType, double power, FuelType fuelType, Shield shield, Antena antena, CarColor color) {
		super(bodyType, power, fuelType, shield, antena, color);
	}

	public BodyType getBodyType( )
	{
		return car.getBodyType();
	}
	
	
}
