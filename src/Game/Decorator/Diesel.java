/**
 * @(#) Coupe.java
 */

package Game.Decorator;

import Game.Builder_Prototype.*;
import Game.GameWindow;

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
		GameWindow.fuelTypes=GameWindow.fuelTypes+" + "+FuelType.DIESEL;
		return FuelType.DIESEL;
	}


}
