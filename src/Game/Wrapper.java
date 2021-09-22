package Game;

public class Wrapper {

    public static Message Decode(String msg){

        String[] messageArray = msg.split("\\.");

        Player player = new Player(messageArray[0]);
        Command command = null;

        if(Command.CONNECT.name().equals(messageArray[1]))
            command = Command.CONNECT;
        else if(Command.ROLL.name().equals(messageArray[1]))
            command = Command.ROLL;
        else if(Command.SEND.name().equals(messageArray[1]))
            command = Command.SEND;

        String text = messageArray[2];

        Message message = new Message(player, command, text);

        return message;
    }

    public static String Encode(Player player, Command command, String text){
        String message = player.GetName() + "." + command.name() + "." + text;
        return message;
    }

}
