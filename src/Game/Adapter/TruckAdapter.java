package Game.Adapter;

import Game.Builder_Prototype.Car;

public class TruckAdapter extends RegularFuelPistol{
    private TruckFuelPistol adaptee;

    public TruckAdapter(TruckFuelPistol adaptee) {
        super();
        this.adaptee = adaptee;
    }

    public double fill( Car car)
    {
        return adaptee.fillTruck(car);
    }
}
