/**
 * @(#) Coupe.java
 */

package Game.Decorator;

import Game.Builder_Prototype.*;

public class Diesel extends Decorator
{
	public Diesel(Car wrapee)
	{
		super(wrapee);
	}

	@Override
	public FuelType getFuelType( )
	{
		this.wrapee.getFuelType();
		System.out.println(" + " + FuelType.DIESEL);
		return FuelType.DIESEL;
	}


}
