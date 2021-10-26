/**
 * @(#) Roadster.java
 */

package Game.Decorator;

import Game.Builder_Prototype.*;
import Game.GameWindow;

public class Petrol extends Decorator
{
	public Petrol(Car wrapee) {
		super(wrapee);
	}

	@Override
	public FuelType getFuelType( )
	{
		this.wrapee.getFuelType();
		GameWindow.fuelTypes=GameWindow.fuelTypes+" + "+FuelType.PETROL;
		return FuelType.PETROL;
	}
}
