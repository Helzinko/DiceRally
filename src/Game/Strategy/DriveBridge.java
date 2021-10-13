package Game.Strategy;

import Game.Builder_Prototype.Car;

public class DriveBridge extends SquareAlgorithm{
    private final int ADDITION = 4;
    @Override
    public double[] doSquareAction(int currentPosition, Car car, int rolled) {
        return new double[] {currentPosition + this.ADDITION, car.fuel - car.getPower() * rolled, car.health};
    }
}
