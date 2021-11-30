package Game.State;

import Game.Builder_Prototype_Bridge.Car;
import Game.Chat;

public class FillHealth extends State{
    public void Handle(Context context, Car car)
    {
        car.health = 100;
        context.setState(this);
    }
}
