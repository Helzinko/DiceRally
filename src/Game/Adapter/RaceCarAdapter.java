package Game.Adapter;

import Game.Builder_Prototype_Bridge.Car;

public class RaceCarAdapter extends RegularFuelPistol{
    private RaceCarFuelPistol adaptee;

    public RaceCarAdapter(RaceCarFuelPistol adaptee) {
        super();
        this.adaptee = adaptee;
    }

    public double fill( Car car)
    {
        return adaptee.fillRaceCar(car);
    }
}
