package Game;

import Game.enums.Antena;
import Game.enums.BodyType;
import Game.enums.CarColor;
import Game.enums.FuelType;

public interface Builder
{
    void setBodyType(BodyType bodyType);
    void setEngine(double power);
    void setFuelType(FuelType fuelType);
    void setShield(int shield);
    void setAntena(Antena antena);
    void setColor(CarColor color);
}