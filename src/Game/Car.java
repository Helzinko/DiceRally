package Game;

import Game.enums.Antena;
import Game.enums.BodyType;
import Game.enums.CarColor;
import Game.enums.FuelType;

public class Car {
    private final BodyType bodyType;
    private final double power;
    private final FuelType fuelType;
    private final int shield;
    private final Antena antena;
    private final CarColor color;

    public Car(BodyType bodyType, double power, FuelType fuelType, int shield, Antena antena, CarColor color)
    {
        this.bodyType = bodyType;
        this.power = power;
        this.fuelType = fuelType;
        this.shield = shield;
        this.antena = antena;
        this.color = color;
    }

    public BodyType getBodyType()
    {
        return bodyType;
    }

    public double getPower()
    {
        return power;
    }

    public FuelType getFuelType()
    {
        return fuelType;
    }

    public int getShield()
    {
        return shield;
    }

    public Antena getAntena()
    {
        return antena;
    }

    public CarColor getColor()
    {
        return color;
    }
}
