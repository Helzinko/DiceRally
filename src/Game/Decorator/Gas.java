package Game.Decorator;

import Game.Builder_Prototype_Bridge.Car;
import Game.Builder_Prototype_Bridge.FuelType;
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
