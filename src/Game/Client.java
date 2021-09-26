package Game;

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

        Player player = null;

        while(!canContinue){
            Thread.yield();
            if(LoginWindow.pressed){
                String name = LoginWindow.loginInputField.getText();
                player = new Player(name);
                String text = " connected!";
                Frame.ShowFrame();
                String message = Wrapper.Encode(player, Command.CONNECT, text);
                out.println(message);
                canContinue = true;
            }
        }

        while(true){
            //String text = keyboard.readLine();
            Thread.yield();
            if(Chat.sendPressed){
                String text = Chat.sendField.getText();
                String message = Wrapper.Encode(player, Command.SEND, text);
                out.println(message);
                Chat.sendField.setText("");
                Chat.sendPressed = false;
            }

            if(Frame.rollPressed){
                String text = String.valueOf(Dice.Roll());
                String message = Wrapper.Encode(player, Command.ROLL, text);
                out.println(message);
                Frame.rollPressed = false;
            }
        }
    }
}