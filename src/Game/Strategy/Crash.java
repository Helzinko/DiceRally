package Game.Strategy;

import Game.Builder_Prototype.Car;

public class Crash extends SquareAlgorithm{
    private final int DAMAGE = 30;
    @Override
    public double[] doSquareAction(int currentPosition, Car car, int rolled) {
        return new double[] {currentPosition, car.fuel - car.getPower() * rolled, car.health - DAMAGE};
    }
}
