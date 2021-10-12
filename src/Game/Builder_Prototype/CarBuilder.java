package Game.Builder_Prototype;

public class CarBuilder implements Builder
{
    private BodyType bodyType;
    private double power;
    private FuelType fuelType;
    private Shield shield;
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
    public void setAntena(Antena antena) {
        this.antena = antena;

    }

    @Override
    public void setColor(CarColor color) {
        this.color = color;

    }

    public void setShield(Shield shield) {
        this.shield = shield;
    }


    public Car getCar() {
        return new Car(bodyType, power, fuelType, shield, antena, color);
    }

    public String getResult() {
        return (bodyType + " " + power + " " + fuelType + " " + shield.getType() + " " + antena + " " + color);
    }
}


