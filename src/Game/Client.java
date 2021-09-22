package Game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;


public class Client{
    private static final String SERVER_IP = "127.0.0.1";
    private static final int SERVER_PORT = 4200;

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(SERVER_IP, SERVER_PORT);

        ServerConnection serverConn = new ServerConnection(socket);

        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out  = new PrintWriter(socket.getOutputStream(), true);

        new Thread(serverConn).start();

        LoginWindow.CreateWindow();

        boolean canContinue = false;

        //System.out.println("Test1");

        Player player = null;

        while(!canContinue){
            Thread.yield();
            if(LoginWindow.pressed){
                String name = LoginWindow.loginInputField.getText();
                player = new Player(name);
                String text = " connected!";
                GameWindow.CreateWindow();
                String message = Wrapper.Encode(player, Command.CONNECT, text);
                out.println(message);
                canContinue = true;
            }
        }

        while(true){
            String text = keyboard.readLine();
            String message = Wrapper.Encode(player, Command.SEND, text);
            out.println(message);
        }
    }
}