package Game.Strategy;

import Game.Builder_Prototype.Car;

public class Jump extends SquareAlgorithm {
    private final int ADDITION = 3;
    private final int DAMAGE = 5;

    @Override
    public double[] doSquareAction(int currentPosition, Car car, int rolled) {
        return new double[] {currentPosition + this.ADDITION, car.fuel - car.getPower() * rolled, car.health - DAMAGE};
    }
}
