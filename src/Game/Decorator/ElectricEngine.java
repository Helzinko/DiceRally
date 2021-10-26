package Game.Decorator;

import Game.Builder_Prototype.Car;
import Game.Builder_Prototype.FuelType;
import Game.Chat;
import Game.Command;
import Game.Facade.Facade;
import Game.GameWindow;
import Game.Wrapper;

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
