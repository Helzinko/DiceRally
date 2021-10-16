/**
 * @(#) Roadster.java
 */

package Game.Decorator;

import Game.Builder_Prototype.*;

public class Petrol extends Decorator
{
	public Petrol(Car component) {
		super(component);
	}

	public FuelType getFuelType( )
	{
		System.out.println(FuelType.PETROL);
		return FuelType.PETROL;
	}
}
