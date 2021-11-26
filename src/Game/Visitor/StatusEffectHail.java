package Game.Visitor;

import Game.Builder_Prototype_Bridge.Car;
import Game.Chat;
import Game.GameWindow;
import Game.Images;

import javax.swing.*;

public class StatusEffectHail implements StatusEffectVisitor {
    @Override
    public void alterBehavior(Car car) {
        int effectDuration = 4;
        if(GameWindow.turnCounter == effectDuration){
            GameWindow.isStatusEffectActive = false;
            GameWindow.statusEffect = null;
            Chat.AddMessage("Hail ended !");
        } else {
            if(GameWindow.turnCounter == 0){
                Chat.AddMessage("Hail started, It is damaging your car !");
            } else {
                Chat.AddMessage("hail will last " + (effectDuration - GameWindow.turnCounter) + " more turn(s) . . .");
                car.health = car.health - 1;
            }
        }
    }
}
