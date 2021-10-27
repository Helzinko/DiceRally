package Game.Builder_Prototype_Bridge;

public class Electric extends Shield{

    double damageReduce = 5;

    public Electric(String type) {
        super(type);
    }

    @Override
    public double reduceDamage(int damage) {
        return damage * (100-damageReduce) / 100;
    }
}
