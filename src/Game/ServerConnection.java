package Game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerConnection implements Runnable {
    private Socket server;
    private BufferedReader in;
    private PrintWriter out;


    public ServerConnection(Socket s) throws IOException {
        server = s;
        in = new BufferedReader(new InputStreamReader(server.getInputStream()));
        out = new PrintWriter(server.getOutputStream(), true);
    }

    @Override
    public void run() {
        try {
            while (true){
                String serverResponse = in.readLine();

                Message msg = Wrapper.Decode(serverResponse);

                if(msg.command == Command.CONNECT)
                {
                    System.out.println(msg.player.GetName() + msg.text);
                    GameWindow.AddMessage(DateFormat.CurrentTime() + msg.player.GetName() + msg.text);
                }
                else if(msg.command == Command.SEND)
                {
                    System.out.println(msg.player.GetName() + " says: " + msg.text);
                    GameWindow.AddMessage(DateFormat.CurrentTime() + msg.player.GetName() + " says: " + msg.text);
                }
                else if(msg.command == Command.ROLL){
                    System.out.println(msg.player.GetName() + " rolled: " + msg.text);
                    GameWindow.AddMessage(DateFormat.CurrentTime() + msg.player.GetName() + " rolled: " + msg.text);
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
