package Game.Builder_Prototype_Bridge;

public class Magic extends Shield{

    double damageReduce = 10;

    public Magic(String type) {
        super(type);
    }

    @Override
    public double reduceDamage(int damage) {
        return damage * (100 - damageReduce) / 100;
    }
}
