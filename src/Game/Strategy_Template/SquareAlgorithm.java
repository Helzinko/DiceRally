package Game.Strategy_Template;

import Game.Builder_Prototype_Bridge.Car;

public abstract class SquareAlgorithm extends SquareSkippingTemplate {
    public abstract double[] doSquareAction(int currentPosition, Car car, int rolled);
}
