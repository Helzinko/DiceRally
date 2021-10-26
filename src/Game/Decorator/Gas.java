package Game.Decorator;

import Game.Builder_Prototype.Car;
import Game.Builder_Prototype.FuelType;
import Game.GameWindow;

public class Gas extends Decorator{
    public Gas(Car wrapee) {
        super(wrapee);
    }

    @Override
    public FuelType getFuelType( )
    {
        wrapee.getFuelType();
        GameWindow.fuelTypes=GameWindow.fuelTypes+" + "+FuelType.GAS;
        return FuelType.GAS;
    }
}
