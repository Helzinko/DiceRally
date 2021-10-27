package Game.Adapter;

import Game.Builder_Prototype_Bridge.Car;
import Game.Chat;

public class RaceCarFuelPistol {
    public double fillRaceCar(Car car){
        Chat.AddMessage("Your race car was filled up to 70l of " + car.getFuelType());
        return 70;
    }
}
