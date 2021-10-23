package Game.Adapter;

import Game.Builder_Prototype.Car;
import Game.Chat;

public class TruckFuelPistol {
    public double fillTruck(Car car){
        Chat.AddMessage("Truck was filled up to 60l of " + car.getFuelType());
        return 100;
    }
}
