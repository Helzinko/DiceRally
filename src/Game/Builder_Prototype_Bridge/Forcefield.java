package Game.Builder_Prototype_Bridge;

public class Forcefield extends Shield{

    double damageReduce = 7;

    public Forcefield(String type) {
        super(type);
    }

    @Override
    public double reduceDamage(int damage) {
        return damage * (100-damageReduce) / 100;
    }
}
