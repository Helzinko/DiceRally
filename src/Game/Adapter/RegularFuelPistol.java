package Game.Adapter;

import Game.Builder_Prototype.Car;
import Game.Chat;

public class RegularFuelPistol {
    public double fill(Car car){
        Chat.AddMessage("Regular car was filled up to 60l of " + car.getFuelType());
        return 60;
    }
}
