package Game.Decorator;

import Game.Builder_Prototype.Car;
import Game.Builder_Prototype.FuelType;

public class Gas extends Decorator{
    public Gas(Car wrapee) {
        super(wrapee);
    }

    @Override
    public FuelType getFuelType( )
    {
        wrapee.getFuelType();
        System.out.println(" + " + FuelType.GAS);
        return FuelType.GAS;
    }
}
