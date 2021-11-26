package Game.Visitor;

import Game.Builder_Prototype_Bridge.Car;

public interface StatusEffectVisitor {
    void alterBehavior(Car car);
}
