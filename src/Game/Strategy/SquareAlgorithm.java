package Game.Strategy;

import Game.Builder_Prototype_Bridge.Car;
import Game.Template.SquareSkippingTemplate;

public abstract class SquareAlgorithm extends SquareSkippingTemplate {
    public abstract double[] doSquareAction(int currentPosition, Car car, int rolled);
}
