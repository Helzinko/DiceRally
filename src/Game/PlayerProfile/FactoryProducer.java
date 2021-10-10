package Game.PlayerProfile;

public class FactoryProducer {

    public static AbstractFactory getFactory(boolean male){
        if(male){
            return new ManFactory();
        }else{
            return new WomanFactory();
        }
    }

}
