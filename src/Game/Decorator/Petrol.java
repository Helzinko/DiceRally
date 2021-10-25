/**
 * @(#) Roadster.java
 */

package Game.Decorator;

import Game.Builder_Prototype.*;

public class Petrol extends Decorator
{
	public Petrol(Car wrapee) {
		super(wrapee);
	}

	@Override
	public FuelType getFuelType( )
	{
		this.wrapee.getFuelType();
		System.out.print(" + " + FuelType.PETROL);
		return FuelType.PETROL;
	}
}
