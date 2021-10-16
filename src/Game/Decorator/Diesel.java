/**
 * @(#) Coupe.java
 */

package Game.Decorator;

import Game.Builder_Prototype.*;

public class Diesel extends Decorator
{
	public Diesel(Car component)
	{
		super(component);
	}

	public FuelType getFuelType( )
	{
		System.out.println(FuelType.DIESEL);
		return FuelType.DIESEL;
	}


}
