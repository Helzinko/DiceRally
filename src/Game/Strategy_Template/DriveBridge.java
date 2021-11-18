package Game.Strategy_Template;

import Game.Builder_Prototype_Bridge.Car;

public class DriveBridge extends SquareAlgorithm{
    private final int ADDITION = 4;
    @Override
    public double[] doSquareAction(int currentPosition, Car car, int rolled) {
        double[] skippingResult = this.skippingProcess(car.health, currentPosition);
        return new double[] {skippingResult[1], car.fuel - car.getPower() * rolled, skippingResult[0]};
//        return new double[] {currentPosition + this.ADDITION, car.fuel - car.getPower() * rolled, car.health};
    }

    @Override
    public boolean ifTakeDamage() {
        return false;
    }

    @Override
    public boolean isSkippingSquare() {
        return true;
    }

    @Override
    public int skipSquares() {
        return 4;
    }
}
