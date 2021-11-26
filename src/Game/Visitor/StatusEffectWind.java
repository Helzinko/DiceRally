package Game.Visitor;

import Game.Builder_Prototype_Bridge.Car;
import Game.Chat;
import Game.GameWindow;

public class StatusEffectWind implements StatusEffectVisitor{
    @Override
    public void alterBehavior(Car car) {
        int effectDuration = 2;
        if(GameWindow.turnCounter == effectDuration){
            GameWindow.isStatusEffectActive = false;
            GameWindow.statusEffect = null;
            Chat.AddMessage("Strong wind ended !");
            car.setPower(car.getPower() - 10);
        } else {
            if(GameWindow.turnCounter == 0){
                Chat.AddMessage("Strong wind started blowing, you use less fuel !");
            } else {
                Chat.AddMessage("Strong wind will last " + (effectDuration - GameWindow.turnCounter) + " more turn(s) . . .");
                car.setPower(car.getPower() + 10);
            }
        }
    }
}
