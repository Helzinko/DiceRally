package Game.PlayerProfile;

public class WomanFactory extends AbstractFactory{

    @Override
    public Person getPerson(String personType) {
        if ("Black".equalsIgnoreCase(personType)) {
            return new WomanBlack();
        }
        else if("Brown".equalsIgnoreCase(personType)){
            return new WomanBrown();
        }
        else if("Red".equalsIgnoreCase(personType)){
            return new WomanRed();
        }
        return null;
    }
}
