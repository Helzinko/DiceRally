package Game.State;

import Game.Builder_Prototype_Bridge.Car;
import Game.Chat;

public class FillFuel extends State{
    public void Handle(Context context, Car car)
    {
        car.fuel = 60;
        context.setState(this);
    }
}
