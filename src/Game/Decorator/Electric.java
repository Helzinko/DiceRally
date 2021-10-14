/**
 * @(#) Roadster.java
 */

package Game.Decorator;

import Game.Builder_Prototype.*;

public class Electric extends Decorator
{
	private Car car;
	public Electric(BodyType bodyType, double power, FuelType fuelType, Shield shield, Antena antena, CarColor color) {
		super(bodyType, power, fuelType, shield, antena, color);
	}

	public FuelType getFuelType( )
	{
		return car.getFuelType();
	}
}
