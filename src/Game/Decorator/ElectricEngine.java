package Game.Decorator;

import Game.Builder_Prototype_Bridge.Car;
import Game.Builder_Prototype_Bridge.FuelType;
import Game.GameWindow;

public class ElectricEngine extends Car {
    private Car car;

    public ElectricEngine(Car component) {
        super();
        car = component;
        getFuelType();
    }

    public FuelType getFuelType()
    {
        GameWindow.fuelTypes=GameWindow.fuelTypes+"  | "+FuelType.ELECTRIC;
        return FuelType.ELECTRIC;
    }
}
