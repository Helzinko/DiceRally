package Game.Builder_Prototype;

public class Car implements Cloneable
{
    private final BodyType bodyType;
    private final double power;
    private final FuelType fuelType;
    private Shield shield;
    private final Antena antena;
    private final CarColor color;
    public double fuel;
    public double health;

    public Car(BodyType bodyType, double power, FuelType fuelType, Shield shield, Antena antena, CarColor color)
    {
        this.bodyType = bodyType;
        this.power = power;
        this.fuelType = fuelType;
        this.shield = shield;
        this.antena = antena;
        this.color = color;
        this.fuel = 60;
        this.health = 100;
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

    public Shield getShield()
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

    public Car copyDeep()
    {
        try {
            Car copy = (Car) this.clone();
            copy.shield = this.shield.copyShallow();
            return copy;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Car copyShallow()
    {
        try {
            return (Car) this.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
