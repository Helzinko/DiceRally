package Game;

import Game.enums.Antena;
import Game.enums.BodyType;
import Game.enums.CarColor;
import Game.enums.FuelType;

public class CarBuilder implements Builder{
    private BodyType bodyType;
    private double power;
    private FuelType fuelType;
    private int shield;
    private Antena antena;
    private CarColor color;

    @Override
    public void setBodyType(BodyType bodyType) {
        this.bodyType = bodyType;
        
    }
    @Override
    public void setEngine(double power) {
        this.power = power;
        
    }
    @Override
    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
        
    }
    @Override
    public void setShield(int shield) {
        this.shield = shield;
        
    }

    @Override
    public void setAntena(Antena antena) {
        this.antena = antena;
        
    }
    @Override
    public void setColor(CarColor color) {
        this.color = color;
        
    }

//    public Car getResult()
//    {
//        return new Car(bodyType, power, fuelType, shield, antena, color);
//    }
    public String getResult()
    {
        return new String(bodyType + " " + power + " " + fuelType + " " + shield + " " + antena + " " + color);
    }
}
