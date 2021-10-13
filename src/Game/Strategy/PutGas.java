package Game.Strategy;

import Game.Builder_Prototype.Car;

public class PutGas extends SquareAlgorithm{

    @Override
    public double[] doSquareAction(int currentPosition, Car car, int rolled) {
        return new double[] {currentPosition, 60, car.health};
    }
}
