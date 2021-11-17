package Game.Strategy;

import Game.Builder_Prototype_Bridge.Car;

public class Neutral extends SquareAlgorithm{

    @Override
    public double[] doSquareAction(int currentPosition, Car car, int rolled) {
        return new double[] {currentPosition, car.fuel, car.health};
    }

    @Override
    public boolean ifTakeDamage() {
        return false;
    }

    @Override
    public boolean isSkippingSquare() {
        return false;
    }

    @Override
    public int skipSquares() {
        return 0;
    }
}
