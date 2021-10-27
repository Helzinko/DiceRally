package Game.Builder_Prototype_Bridge;

public interface Builder
{
    void setBodyType(BodyType bodyType);
    void setEngine(double power);
    void setFuelType(FuelType fuelType);
    void setAntena(Antena antena);
    void setColor(CarColor color);
    void setShield(Shield shield);

//    default void addShield(Shield shield)
//    {
//        this.setShield(shield);
//    }

    default void addElectricShield()
    {
        this.setShield(new Electric("electric shield"));
    }

    default void addForcefieldShield()
    {
        this.setShield(new Forcefield("forcefield shield"));
    }

    default void addMagicShield()
    {
        this.setShield(new Magic("magic shield"));
    }
}