package Game;

import Game.CommandPattern.Controller;
import Game.CommandPattern.ICommand;
import Game.CommandPattern.RollCommand;
import Game.CommandPattern.SendCommand;
import Game.PlayerProfile.AbstractFactory;
import Game.PlayerProfile.FactoryProducer;
import Game.PlayerProfile.Person;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Arrays;

public class ServerConnection implements Runnable {
    private Socket server;
    private BufferedReader in;
    private PrintWriter out;
    private int playerID;


    public ServerConnection(Socket s, int playerID) throws IOException {
        server = s;
        in = new BufferedReader(new InputStreamReader(server.getInputStream()));
        out = new PrintWriter(server.getOutputStream(), true);
        this.playerID = playerID;
    }

    @Override
    public void run() {
        try {
            while (true){
                String serverResponse = in.readLine();

                Message msg = Wrapper.Decode(serverResponse, playerID);
                if(msg.command == Command.CONNECT)
                {
                    System.out.println(msg.player.GetName() + msg.text);
                    Chat.AddMessage(DateFormat.CurrentTime() + msg.player.GetName() + msg.text);
                }
                else if(msg.command == Command.SEND)
                {
                    //Uzkomentuota del command sablono
                    //System.out.println(msg.player.GetName() + " says: " + msg.text);
                    //Chat.AddMessage(DateFormat.CurrentTime() + msg.player.GetName() + " says: " + msg.text);

                    //Naudojama command sablonui
                    //Controller ctrl = new Controller();
                    //ICommand cmd = new SendCommand(msg);
                    //ctrl.run(cmd);

                    msg.player.sendMessage(msg.text);

                }
                else if(msg.command == Command.ROLL){
                    String[] messageArray = msg.text.split(",");
                    Chat.AddMessage(DateFormat.CurrentTime() + msg.player.GetName() + " rolled: " + messageArray[0]);
                    Frame.updatePlayerInfo(msg.player.GetName(), Double.parseDouble(messageArray[2]), Double.parseDouble(messageArray[3]));
                    if(Client.playerName != null){
                        if(!Client.playerName.equals(msg.player.GetName())){
                            GameWindow.EnemyRolled(messageArray);
                        }
                    }
                }
                else if(msg.command == Command.PAUSE){
                    String[] messageArray = msg.text.split(",");
                    Chat.AddMessage(DateFormat.CurrentTime() + msg.player.GetName() + " " + messageArray[0]);
                    if(Client.playerName != null){
                        if(!Client.playerName.equals(msg.player.GetName())){
                            GameWindow.EnemyPaused(GameWindow.pausePlayPressed);
                        }
                    }
                }
                else if(msg.command == Command.PROFILE){
                    String[] messageArray = msg.text.split(",");
                    String[] profileArray = messageArray[0].split("-");

                    if(!msg.player.GetName().equals(Client.playerName)){
                        AbstractFactory shapeFactory = FactoryProducer.getFactory(Boolean.parseBoolean(profileArray[1]));
                        Person person = shapeFactory.getPerson(profileArray[0]);
                        Frame.DrawEnemyProfile(person, profileArray[2]);
                    }
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
