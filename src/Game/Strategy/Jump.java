package Game.Strategy;

import Game.Builder_Prototype_Bridge.Car;
import Game.Chat;

public class Jump extends SquareAlgorithm {
    private final int ADDITION = 3;
    private final int DAMAGE = 5;

    @Override
    public double[] doSquareAction(int currentPosition, Car car, int rolled) {
        double[] skippingResult = this.skippingProcess(car.health, currentPosition);
//        return new double[] {currentPosition + this.ADDITION, car.fuel - car.getPower() * rolled, car.health - car.getShield().reduceDamage(DAMAGE)};
        return new double[] {skippingResult[1], car.fuel - car.getPower() * rolled, skippingResult[0]};
    }

    @Override
    public boolean ifTakeDamage() {
        return true;
    }

    @Override
    public boolean isSkippingSquare() {
        return true;
    }

    @Override
    public int skipSquares() {
        return 3;
    }
}
