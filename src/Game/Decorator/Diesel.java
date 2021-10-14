/**
 * @(#) Coupe.java
 */

package Game.Decorator;

import Game.Builder_Prototype.*;

public class Diesel extends Decorator
{
	private Car car;
	public Diesel(BodyType bodyType, double power, FuelType fuelType, Shield shield, Antena antena, CarColor color) {
		super(bodyType, power, fuelType, shield, antena, color);
	}

	public FuelType getFuelType( )
	{
		return car.getFuelType();
	}
	
	
}
