package Game.Strategy;

import Game.Builder_Prototype_Bridge.Car;

public class Crash extends SquareAlgorithm{
    private final int DAMAGE = 30;
    @Override
    public double[] doSquareAction(int currentPosition, Car car, int rolled) {
        System.out.println(car.getShield().reduceDamage(DAMAGE));
        return new double[] {currentPosition, car.fuel - car.getPower() * rolled, car.health - car.getShield().reduceDamage(DAMAGE)};
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
