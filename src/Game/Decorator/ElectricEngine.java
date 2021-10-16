package Game.Decorator;

import Game.Builder_Prototype.Car;
import Game.Builder_Prototype.FuelType;

public class ElectricEngine extends Car {
    private Car car;

    public ElectricEngine(Car component) {
        super();
        car = component;
        getFuelType();
    }

    public FuelType getFuelType()
    {
        System.out.print(FuelType.ELECTRIC + " + ");
        return FuelType.ELECTRIC;
    }
}
