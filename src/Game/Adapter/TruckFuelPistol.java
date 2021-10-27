package Game.Adapter;

import Game.Builder_Prototype_Bridge.Car;
import Game.Chat;

public class TruckFuelPistol {
    public double fillTruck(Car car){
        Chat.AddMessage("Your truck was filled up to 60l of " + car.getFuelType());
        return 100;
    }
}
