package Game.Strategy;

import Game.Builder_Prototype.Car;

public class Fix extends SquareAlgorithm{
    @Override
    public double[] doSquareAction(int currentPosition, Car car, int rolled) {
        return new double[] {currentPosition, car.fuel - car.getPower() * rolled, 100};
    }
}
