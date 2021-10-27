package Game.Strategy;

import Game.Builder_Prototype_Bridge.Car;

public abstract class SquareAlgorithm {
    public abstract double[] doSquareAction(int currentPosition, Car car, int rolled);
}
