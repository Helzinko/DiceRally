package Game.Strategy;

import Game.Adapter.*;
import Game.Builder_Prototype_Bridge.Car;

public class PutGas extends SquareAlgorithm{

    @Override
    public double[] doSquareAction(int currentPosition, Car car, int rolled) {
        double filled;
        switch (car.getBodyType()){
            case RACE_CAR:
                filled = car.fillCarTank(new RaceCarAdapter(new RaceCarFuelPistol()));
                break;
            case TRUCK_CAR:
                filled = car.fillCarTank(new TruckAdapter(new TruckFuelPistol()));
                break;
            default:
                filled = car.fillCarTank(new RegularFuelPistol());
        }
        return new double[] {currentPosition, filled, car.health};
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
