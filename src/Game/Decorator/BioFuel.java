/**
 * @(#) Pickup.java
 */

package Game.Decorator;

import Game.Builder_Prototype.*;

public class BioFuel extends Decorator
{
	public BioFuel(Car component) {
		super(component);
	}

	public FuelType getFuelType( )
	{
		System.out.println(FuelType.BIO_FUEL);
		return FuelType.BIO_FUEL;
	}
}
