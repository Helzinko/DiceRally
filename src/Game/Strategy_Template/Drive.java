package Game.Strategy_Template;

import Game.Builder_Prototype_Bridge.Car;

public class Drive extends SquareAlgorithm{
    @Override
    public double[] doSquareAction(int currentPosition, Car car, int rolled) {
        return new double[] {currentPosition, car.fuel - car.getPower() * rolled, car.health};
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
