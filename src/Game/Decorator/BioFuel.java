/**
 * @(#) Pickup.java
 */

package Game.Decorator;

import Game.Builder_Prototype_Bridge.*;
import Game.GameWindow;

public class BioFuel extends Decorator
{
	public BioFuel(Car wrapee) {
		super(wrapee);
	}

	@Override
	public FuelType getFuelType( )
	{
		this.wrapee.getFuelType();
		GameWindow.fuelTypes=GameWindow.fuelTypes+" + "+FuelType.BIO_FUEL;;
		return FuelType.BIO_FUEL;
	}
}
