package Game.Adapter;

import Game.Builder_Prototype_Bridge.Car;
import Game.Chat;

public class RegularFuelPistol {
    public double fill(Car car){
        Chat.AddMessage("Your rally car was filled up to 60l of " + car.getFuelType());
        return 60;
    }
}
