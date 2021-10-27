package Game.Strategy;

import Game.Builder_Prototype_Bridge.Car;
import Game.Chat;

public class Fix extends SquareAlgorithm{
    @Override
    public double[] doSquareAction(int currentPosition, Car car, int rolled) {
        Chat.AddMessage("Your car has been fixed :)");
        return new double[] {currentPosition, car.fuel - car.getPower() * rolled, 100};
    }
}
