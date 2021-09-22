package Game;

public class Message {

    public Player player;
    public Command command;
    public String text;

    public Message(Player player, Command command, String text){
        this.player = player;
        this.command = command;
        this.text = text;
    }

}
