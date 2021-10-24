package Game.Strategy;

import Game.Builder_Prototype.Car;
import Game.Chat;

public class Jump extends SquareAlgorithm {
    private final int ADDITION = 3;
    private final int DAMAGE = 5;

    @Override
    public double[] doSquareAction(int currentPosition, Car car, int rolled) {
        Chat.AddMessage("You jumped over the ramp and skipped 3 squares");
        return new double[] {currentPosition + this.ADDITION, car.fuel - car.getPower() * rolled, car.health - DAMAGE};
    }
}
