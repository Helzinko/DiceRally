package Game.Mediator;

import Game.Chat;
import Game.DateFormat;
import Game.Player;

public class ChatRoom {
    public static void showMessage(Player player, String message){
        System.out.println(DateFormat.CurrentTime() + player.GetName() + " says: " + message);
        Chat.AddMessage(DateFormat.CurrentTime() + player.GetName() + " says: " + message);
    }
}
