package Game;

import Game.CommandPattern.Controller;
import Game.CommandPattern.ICommand;
import Game.CommandPattern.RollCommand;
import Game.CommandPattern.SendCommand;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

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
                Chat.AddMessage(DateFormat.CurrentTime() + msg.command);
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
                    Controller ctrl = new Controller();
                    ICommand cmd = new SendCommand(msg);
                    ctrl.run(cmd);
                }
                else if(msg.command == Command.ROLL){
                    String[] messageArray = msg.text.split(",");
                    Chat.AddMessage(DateFormat.CurrentTime() + msg.player.GetName() + " rolled: " + messageArray[0]);

                    if(Client.playerName != null){
                        if(!Client.playerName.equals(msg.player.GetName())){
                            GameWindow.EnemyRolled(messageArray);
                        }
                    }
                }
                else if(msg.command == Command.PAUSE){
                    if(Client.playerName != null){
                        if(!Client.playerName.equals(msg.player.GetName())){
                            GameWindow.EnemyPaused();
                        }
                    }
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
