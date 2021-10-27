package Game.Builder_Prototype_Bridge;

public abstract class Shield implements Cloneable
{
    private String type;

    public Shield(String type)
    {
        super();
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public abstract double reduceDamage(int damage);

    public Shield copyShallow()
    {
        try {
            return (Shield)this.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Shield copyDeep()
    {
        try {
            return (Shield)this.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
