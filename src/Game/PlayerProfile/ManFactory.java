package Game.PlayerProfile;

public class ManFactory extends AbstractFactory{

    @Override
    public Person getPerson(String personType) {
        if ("Black".equalsIgnoreCase(personType)) {
            return new ManBlack();
        }
        else if("Brown".equalsIgnoreCase(personType)){
            return new ManBrown();
        }
        else if("Red".equalsIgnoreCase(personType)){
            return new ManRed();
        }
        return null;
    }
}
