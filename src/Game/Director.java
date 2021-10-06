package Game;

import Game.enums.Antena;
import Game.enums.BodyType;
import Game.enums.CarColor;
import Game.enums.FuelType;

public class Director 
{
    public void constructRaceCar(Builder builder)
    {
        builder.setBodyType(BodyType.RACE_CAR);
        builder.setEngine(2.0);
        builder.setFuelType(FuelType.PETROL);
        builder.setAntena(Antena.USA_FLAG);
        builder.setColor(CarColor.RED);
    }

    public void constructRallyCar(Builder builder)
    {
        builder.setBodyType(BodyType.RALLY_CAR);
        builder.setEngine(3.5);
        builder.setFuelType(FuelType.DIESEL);
        builder.setShield(20);
        builder.setColor(CarColor.BLUE);    
    }

    public void constructTruckCar(Builder builder)
    {
        builder.setBodyType(BodyType.TRUCK_CAR);
        builder.setEngine(6);
        builder.setFuelType(FuelType.BIO_FUEL);
        builder.setShield(50);
        builder.setAntena(Antena.TEDDY_BEAR);
        builder.setColor(CarColor.GREEN);
    }
}
